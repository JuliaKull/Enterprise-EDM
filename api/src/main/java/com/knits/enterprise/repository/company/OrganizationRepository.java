package com.knits.enterprise.repository.company;

import com.knits.enterprise.model.common.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>,PagingAndSortingRepository<Organization, Long>,
        JpaSpecificationExecutor<Organization> {
}
