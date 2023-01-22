package com.knits.enterprise.mocks.dto;


import com.knits.enterprise.config.Constants;
import com.knits.enterprise.dto.company.DepartmentDto;

import java.time.LocalDateTime;

public class DepartmentDtoMock {

        public static DepartmentDto shallowDepartmentDto(Long id) {
            return DepartmentDto.builder()
                    .id(id)
                    .name("Mock Department"+id)
                    .startDate(LocalDateTime.now().format(Constants.DATE_FORMATTER))
                    .endDate(LocalDateTime.now().plusMonths(12).format(Constants.DATE_FORMATTER))
                    .active(true)
                    .build();
        }
}
