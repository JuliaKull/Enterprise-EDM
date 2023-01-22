package com.knits.enterprise.service.company;

import com.knits.enterprise.dto.company.DivisionDto;
import com.knits.enterprise.dto.search.DivisionSearchDto;
import com.knits.enterprise.exceptions.UserException;
import com.knits.enterprise.mapper.company.DivisionMapper;
import com.knits.enterprise.model.company.Division;
import com.knits.enterprise.repository.company.DivisionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DivisionService {
    private DivisionRepository repository;
    private DivisionMapper mapper;

    public DivisionDto createDivision(DivisionDto divisionDto) {
        log.debug("Request to save Division : {}", divisionDto);

        final Division businessUnit = mapper.toEntity(divisionDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    public void deleteDivision(Long id) {
        log.debug("Delete Division by id : {}", id);
        repository.deleteById(id);
    }


    public DivisionDto partialUpdate(DivisionDto divisionDto) {
        log.debug("Request to update Division : {}", divisionDto);

        Division division = repository.findById(divisionDto.getId()).orElseThrow(()
                -> new UserException("Division#" + divisionDto.getId() + " not found"));

        mapper.partialUpdate(division, divisionDto);
        repository.save(division);
        return mapper.toDto(division);
    }

    public Page<DivisionDto> getActive(DivisionSearchDto divisionSearchDto) {

        Page<Division> businessUnitPage = repository.findAllDivisions(divisionSearchDto.getSpecification(), divisionSearchDto.getPageable());
        List<DivisionDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, divisionSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }

    public Page<DivisionDto> getAll(DivisionSearchDto divisionSearchDto) {

        Page<Division> businessUnitPage = repository.findAll(divisionSearchDto.getSpecification(), divisionSearchDto.getPageable());
        List<DivisionDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, divisionSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }
}
