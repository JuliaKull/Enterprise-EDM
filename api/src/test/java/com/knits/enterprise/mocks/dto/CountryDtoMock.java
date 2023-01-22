package com.knits.enterprise.mocks.dto;

import com.knits.enterprise.dto.common.CountryDto;

public class CountryDtoMock {

    public static CountryDto shallowCountryDto(Long id){

        return CountryDto.builder()
                .id(id)
                .name("A mock name")
                .build();
    }

}
