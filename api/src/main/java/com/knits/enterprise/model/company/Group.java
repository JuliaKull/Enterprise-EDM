package com.knits.enterprise.model.company;


import com.knits.enterprise.model.security.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.CascadeType.ALL;


@Entity
@Data
@NoArgsConstructor
//@SuperBuilder(toBuilder=true)
@Table(name = "Group")
public class Group extends AbstractOrganizationStructure implements Serializable {

    @OneToMany(cascade = ALL)
    private List<Employee> employeesList;

}
