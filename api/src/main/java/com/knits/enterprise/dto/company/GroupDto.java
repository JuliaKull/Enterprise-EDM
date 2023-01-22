package com.knits.enterprise.dto.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@SuperBuilder(toBuilder=true)
public class GroupDto extends AbstractOrganizationStructureDto{

}
