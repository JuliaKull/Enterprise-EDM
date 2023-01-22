package com.knits.enterprise.service.company;

import com.knits.enterprise.dto.company.BusinessUnitDto;
import com.knits.enterprise.dto.search.BusinessUnitSearchDto;
import com.knits.enterprise.exceptions.UserException;
import com.knits.enterprise.mapper.company.BusinessUnitMapper;
import com.knits.enterprise.model.company.BusinessUnit;
import com.knits.enterprise.repository.company.BusinessUnitRepository;
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
public class BusinessUnitService {

    private final BusinessUnitRepository repository;
    private final BusinessUnitMapper mapper;


    public BusinessUnitDto createBusinessUnit(BusinessUnitDto businessUnitDto) {
        log.debug("Request to save BusinessUnit : {}", businessUnitDto);

        final BusinessUnit businessUnit = mapper.toEntity(businessUnitDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    @Transactional
    public BusinessUnitDto updateBusinessUnit(BusinessUnitDto businessUnitDto) {
        log.debug("Request to update BusinessUnit : {}", businessUnitDto);

        BusinessUnit businessUnit = repository.findById(businessUnitDto.getId()).orElseThrow(()
                -> new UserException("BusinessUnit#" + businessUnitDto.getId() + " not found"));
        mapper.update(businessUnit, businessUnitDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    @Transactional
    public BusinessUnitDto partialUpdate(BusinessUnitDto businessUnitDto) {
        log.debug("Request to update BusinessUnit : {}", businessUnitDto);

        BusinessUnit businessUnit = repository.findById(businessUnitDto.getId()).orElseThrow(()
                -> new UserException("BusinessUnit#" + businessUnitDto.getId() + " not found"));

        mapper.partialUpdate(businessUnit, businessUnitDto);
        repository.save(businessUnit);
        return mapper.toDto(businessUnit);
    }

    public void deleteBusinessUnit(Long id) {
        log.debug("Delete BusinessUnit by id : {}", id);
        repository.deleteById(id);
    }

    public Page<BusinessUnitDto> getActive(BusinessUnitSearchDto businessUnitSearchDto) {

        Page<BusinessUnit> businessUnitPage = repository.findAllBusinessUnit(businessUnitSearchDto.getSpecification(), businessUnitSearchDto.getPageable());
        List<BusinessUnitDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, businessUnitSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }

    public Page<BusinessUnitDto> getAll(BusinessUnitSearchDto businessUnitSearchDto) {

        Page<BusinessUnit> businessUnitPage = repository.findAll(businessUnitSearchDto.getSpecification(), businessUnitSearchDto.getPageable());
        List<BusinessUnitDto> businessUnitDtos = mapper.toDtos(businessUnitPage.getContent());
        return new PageImpl<>(businessUnitDtos, businessUnitSearchDto.getPageable(), businessUnitPage.getTotalElements());
    }

}
