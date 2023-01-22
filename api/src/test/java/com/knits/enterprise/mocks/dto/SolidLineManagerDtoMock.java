package com.knits.enterprise.mocks.dto;


import com.knits.enterprise.dto.company.EmployeeDto;

public class SolidLineManagerDtoMock {
    public static EmployeeDto shallowSolidLineManagerDto(Long id){
        return EmployeeDto.builder()
                .id(id)
                .firstName(EmployeeDtoMock.shallowEmployeeDto(id).getFirstName())
                .lastName(EmployeeDtoMock.shallowEmployeeDto(id).getLastName())
                .build();
    }
}
