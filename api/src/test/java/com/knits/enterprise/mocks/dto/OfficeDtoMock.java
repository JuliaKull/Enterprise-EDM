package com.knits.enterprise.mocks.dto;


import com.knits.enterprise.dto.company.OfficeDto;

public class OfficeDtoMock {
    public static OfficeDto shallowOfficeDto(Long id) {
        return OfficeDto.builder()
                .id(id)
                .name("Mock Office"+id)
                .build();
    }
}
