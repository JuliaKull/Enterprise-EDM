package com.knits.enterprise.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
//@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder(toBuilder=true)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
}
