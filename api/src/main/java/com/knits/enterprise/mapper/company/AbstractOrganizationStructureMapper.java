package com.knits.enterprise.mapper.company;

import com.knits.enterprise.config.Constants;
import com.knits.enterprise.dto.company.AbstractOrganizationStructureDto;
import com.knits.enterprise.dto.company.BusinessUnitDto;
import com.knits.enterprise.mapper.common.EntityMapper;
import com.knits.enterprise.mapper.security.UserMapper;
import com.knits.enterprise.model.common.AbstractEntity;
import com.knits.enterprise.model.company.AbstractOrganizationStructure;
import com.knits.enterprise.model.company.BusinessUnit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

public interface AbstractOrganizationStructureMapper<E extends AbstractOrganizationStructure, D extends AbstractOrganizationStructureDto> extends  EntityMapper<E,D>{

    @Mapping(source = "startDate", target = "startDate", dateFormat = Constants.DATE_FORMAT_DD_MM_YYYYY)
    @Mapping(source = "endDate", target = "endDate", dateFormat = Constants.DATE_FORMAT_DD_MM_YYYYY,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    @Mapping(target = "createdBy", ignore = true)
    D toDto(E entity);
}
