package com.knits.enterprise.service.company;

import com.knits.enterprise.mocks.dto.EmployeeDtoMock;
import com.knits.enterprise.model.company.Employee;
import com.knits.enterprise.repository.company.EmployeeRepository;
import com.knits.enterprise.dto.company.EmployeeDto;
import com.knits.enterprise.mapper.company.EmployeeMapper;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {EmployeeService.class})
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Spy
    private EmployeeMapper employeeMapper;

    @Captor
    private ArgumentCaptor<Employee> employeeArgumentCaptor;

    @InjectMocks
    private EmployeeService employeeService;


    @Test
    @DisplayName("Save new employee")
    void saveNewEmployee() {

        EmployeeDto toSaveDto = EmployeeDtoMock.shallowEmployeeDto(null);

        when(employeeRepository.save(Mockito.any(Employee.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        EmployeeDto savedDto = employeeService.saveNewEmployee(toSaveDto);

        verify(employeeRepository).save(employeeArgumentCaptor.capture());
        Employee toSaveEntity = employeeArgumentCaptor.getValue();

        verify(employeeMapper, times(1)).toDto(toSaveEntity);
        verify(employeeMapper, times(1)).toEntity(toSaveDto);
        verify(employeeRepository, times(1)).save(toSaveEntity);

        assertThat(toSaveDto).isEqualTo(savedDto);

    }


    @Test
    void findEmployeeById() {

    }

    @Test
    void updateEmployee() {

    }

    @Test
    void deleteEmployee() {
    }
}