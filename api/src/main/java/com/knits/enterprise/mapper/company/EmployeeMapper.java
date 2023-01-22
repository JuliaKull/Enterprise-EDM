package com.knits.enterprise.mapper.company;

import com.knits.enterprise.dto.company.EmployeeDto;
import com.knits.enterprise.mapper.common.EntityMapper;
import com.knits.enterprise.mapper.common.OrganizationMapper;
import com.knits.enterprise.mapper.location.LocationMapper;
import com.knits.enterprise.mapper.security.RolerMapper;
import com.knits.enterprise.model.company.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {OrganizationMapper.class, DivisionMapper.class, BusinessUnitMapper.class,
                CostCenterMapper.class, GroupMapper.class, JobTitleMapper.class, TeamMapper.class,
                DepartmentMapper.class, LocationMapper.class, RolerMapper.class})
public interface EmployeeMapper extends EntityMapper<Employee, EmployeeDto> {

}
