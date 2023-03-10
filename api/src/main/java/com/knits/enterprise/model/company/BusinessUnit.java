package com.knits.enterprise.model.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder=true)
@Table(name = "business_units")
public class BusinessUnit extends AbstractOrganizationStructure implements Serializable{

}
