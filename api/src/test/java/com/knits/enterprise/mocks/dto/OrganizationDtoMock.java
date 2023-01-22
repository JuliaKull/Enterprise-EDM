package com.knits.enterprise.mocks.dto;


import com.knits.enterprise.dto.common.OrganizationDto;

public class OrganizationDtoMock {
    public static OrganizationDto shallowOrganizationDto(Long id) {
        return OrganizationDto.builder()
                .id(id)
                .name("Mock Organization"+id)
                .build();
    }
}
