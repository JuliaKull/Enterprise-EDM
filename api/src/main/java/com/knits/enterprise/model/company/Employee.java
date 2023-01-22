package com.knits.enterprise.model.company;

import com.knits.enterprise.model.common.Organization;
import com.knits.enterprise.model.location.Location;
import com.knits.enterprise.model.security.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "email", length = 254, unique = true, nullable = false)
    private String email;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDateTime dateOfBirth;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    private Gender gender;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "company_phone", nullable = false)
    private String companyPhone;

    @Column(name = "company_mobile_number", nullable = false)
    private String companyMobileNumber;


    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    private Role role;


    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "business_unit", referencedColumnName = "business_unit_id")
    private BusinessUnit businessUnit;


    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "organization", referencedColumnName = "id")
    private Organization organization;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "office", referencedColumnName = "id")
    private Location office;


    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "job_title", referencedColumnName = "id")
    private JobTitle jobTitle;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "department", referencedColumnName = "id")
    private Department department;


    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "division", referencedColumnName = "id")
    private Division division;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "solid_line_manager", referencedColumnName = "id", nullable = false)
    private Employee solidLineManager;



}


