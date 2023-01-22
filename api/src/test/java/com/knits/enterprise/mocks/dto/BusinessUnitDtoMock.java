package com.knits.enterprise.mocks.dto;

import com.knits.enterprise.config.Constants;
import com.knits.enterprise.dto.company.BusinessUnitDto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class BusinessUnitDtoMock {

    public static BusinessUnitDto shallowBusinessUnitDto(Long id) {

        return BusinessUnitDto.builder()
                .id(id)
                .name("Mock")
                .description("Mock description")
                .startDate(LocalDateTime.now().format(Constants.DATE_FORMATTER))
                .endDate(LocalDateTime.now().plusMonths(12).format(Constants.DATE_FORMATTER))
                .active(true)
                .build();
    }
}
