package com.knits.enterprise.dto.company;

import com.knits.enterprise.dto.common.OrganizationDto;
import com.knits.enterprise.dto.security.RoleDto;
import com.knits.enterprise.model.company.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;
    @NotNull()
    private String firstName;
    @NotNull()
    private String lastName;

    private String email;

    @NotNull()
    private String dateOfBirth;

    @NotNull()
    private Gender gender;

    @NotNull()
    private String startDate;

    @NotNull()
    private String endDate;

    @NotNull()
    private String companyPhone;

    @NotNull()
    private String companyMobileNumber;

    @NotNull()
    private RoleDto role;

    @NotNull()
    private BusinessUnitDto businessUnit;

    @NotNull()
    private OrganizationDto organization;

//    @NotNull()
//    private OfficeDto office;

    @NotNull()
    private JobTitleDto jobTitle;

    @NotNull()
    private DepartmentDto department;

    @NotNull()
    private DivisionDto division;

    @NotNull()
    private EmployeeDto solidLineManager;
}

