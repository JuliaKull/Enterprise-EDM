package com.knits.enterprise.mocks.dto;

import com.knits.enterprise.config.Constants;
import com.knits.enterprise.dto.company.CostCenterDto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CostCenterDtoMock {

    public static CostCenterDto shallowCostCenterDto(Long id) {

        return CostCenterDto.builder()
                .id(id)
                .name("Mock")
                .description("Mock description")
                .startDate(LocalDateTime.now().format(Constants.DATE_FORMATTER))
                .endDate(LocalDateTime.now().plusMonths(12).format(Constants.DATE_FORMATTER))
                .active(true)
                .build();
    }
}
