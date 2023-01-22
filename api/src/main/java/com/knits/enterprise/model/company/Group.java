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





@Entity
@Data
@NoArgsConstructor
//@SuperBuilder(toBuilder=true)
@Table(name = "[group]")
public class Group extends AbstractOrganizationStructure implements Serializable {

}
