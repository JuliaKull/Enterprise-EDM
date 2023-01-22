package com.knits.enterprise.dto.company;

import com.knits.enterprise.dto.security.UserDto;
import com.knits.enterprise.model.common.AbstractEntity;
import com.knits.enterprise.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder=true)
public class AbstractOrganizationStructureDto  {

    private Long id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private boolean active;
    private UserDto createdBy;
}
