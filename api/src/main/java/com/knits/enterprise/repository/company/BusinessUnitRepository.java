package com.knits.enterprise.repository.company;

import com.knits.enterprise.model.company.BusinessUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessUnitRepository extends JpaRepository<BusinessUnit, Long>,PagingAndSortingRepository<BusinessUnit, Long>,
        JpaSpecificationExecutor<BusinessUnit> {

    @Query("SELECT e from BusinessUnit e where e.active = true ")
    Page<BusinessUnit> findAllBusinessUnit(Specification<BusinessUnit> businessUnitSpecification, Pageable pageable);
}
