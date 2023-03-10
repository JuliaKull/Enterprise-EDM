package com.knits.enterprise.dto.company;

import com.knits.enterprise.dto.security.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder=true)
public class BusinessUnitDto extends AbstractOrganizationStructureDto {

}

