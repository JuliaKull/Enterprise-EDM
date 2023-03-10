package com.knits.enterprise.service.company;


import com.knits.enterprise.dto.company.BusinessUnitDto;
import com.knits.enterprise.dto.search.BusinessUnitSearchDto;
import com.knits.enterprise.mapper.company.BusinessUnitMapper;
import com.knits.enterprise.mapper.security.UserMapper;
import com.knits.enterprise.mocks.dto.BusinessUnitDtoMock;
import com.knits.enterprise.mocks.model.BusinessUnitMock;
import com.knits.enterprise.model.company.BusinessUnit;
import com.knits.enterprise.repository.company.BusinessUnitRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BusinessUnitServiceTest {

    @Mock
    BusinessUnitRepository repository;

    @Spy
    private final BusinessUnitSearchDto searchDto = new BusinessUnitSearchDto();

    @InjectMocks
    BusinessUnitService service;

    @Spy
    private BusinessUnitMapper mapper;

    @Spy
    private UserMapper userMapper;

    @Captor
    private ArgumentCaptor<BusinessUnit> captor;

    @Test
    @DisplayName("Save BusinessUnit Success")
    void saveSuccess() {

        //1) create some mock data (make them reusable in other tests)

        BusinessUnitDto toSaveDto = BusinessUnitDtoMock.shallowBusinessUnitDto(null);

        //2) prepare mocks for everything they should return
        when(repository.save(Mockito.any(BusinessUnit.class))) //any object of type User will match here
                .thenAnswer(i -> i.getArguments()[0]); //echo 1st parameter received

        //3) class under test
        BusinessUnitDto savedDto = service.createBusinessUnit(toSaveDto);

        //4) use captor in spy/mocks for everything they get as input
        verify(repository).save(captor.capture());
        BusinessUnit toSaveEntity = captor.getValue();

        //5) check if all dependencies were called (eventually with check on input data)
        verify(mapper, times(1)).toEntity(toSaveDto);
        verify(repository, times(1)).save(toSaveEntity);
        verify(mapper, times(1)).toDto(toSaveEntity);

        //6) assertions actual vs expected
        assertThat(toSaveDto).isEqualTo(savedDto); //not usually a good practice, but equals has override using all fields
    }

    @Test
    @DisplayName("partial Update success")
    void partialUpdate() {

        Long entityIdToUpdate = 1L;
        String updateTitleTo = "updatedTitleOfBusinessUnit";

        BusinessUnit foundEntity = BusinessUnitMock.shallowBusinessUnit(entityIdToUpdate);
        BusinessUnitDto toUpdateDto = mapper.toDto(foundEntity); //this is recorded therefore time expected is 2
        toUpdateDto.setName(updateTitleTo);


        when(repository.findById(entityIdToUpdate)).thenReturn(Optional.of(foundEntity));

        BusinessUnitDto updatedDto = service.partialUpdate(toUpdateDto);

        verify(repository).save(captor.capture());
        BusinessUnit toUpdateEntity = captor.getValue();

        verify(mapper, times(1)).partialUpdate(toUpdateEntity, toUpdateDto);
        verify(repository, times(1)).save(foundEntity);
        verify(mapper, times(2)).toDto(foundEntity);

        assertThat(toUpdateDto).isEqualTo(updatedDto);
    }

    @Test
    @DisplayName("delete success")
    void deleteSuccess() {
        Long entityIdToDelete = 1L;
        service.deleteBusinessUnit(entityIdToDelete);
    }
}
