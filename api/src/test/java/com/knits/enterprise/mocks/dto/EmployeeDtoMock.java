package com.knits.enterprise.mocks.dto;

import com.knits.enterprise.dto.company.EmployeeDto;
import com.knits.enterprise.model.company.Gender;



public class EmployeeDtoMock {

    public static EmployeeDto shallowEmployeeDto(Long id) {
        return EmployeeDto.builder()
                .id(id)
                .firstName("John"+id)
                .lastName("Doe"+id)
                .email("employye@gmail.com")
                .dateOfBirth("10/10/2000")
                .gender(Gender.MALE)
                .startDate("10/11/2022")
                .companyPhone("123456789")
                .companyMobileNumber("123456789")
                //.role(new RoleDto(id, RoleDtoMock.shallowRoleDto(id).getName()))
               // .businessUnit(new BusinessUnitDto(id, BusinessUnitDtoMock.shallowBusinessUnitDto(id).getName()))
                //.organization(new OrganizationDto(id, OrganizationDtoMock.shallowOrganizationDto(id).getName()))
                //.office(new OfficeDto(id, OfficeDtoMock.shallowOfficeDto(id).getName()))
                //.jobTitle(new JobTitleDto(id, JobTitleDtoMock.shallowJobTitleDto(id).getName()))
                //.department(new DepartmentDto(id, DepartmentDtoMock.shallowDepartmentDto(id).getName()))
                //.division(new DivisionDto(id, DivisionDtoMock.shallowDivisionDto(id).getName()))
                .build();
    }
}
