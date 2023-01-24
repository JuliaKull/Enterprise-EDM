package com.knits.enterprise.repository.company;

import com.knits.enterprise.model.company.JobTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTitleRepository extends PagingAndSortingRepository<JobTitle, Long>,
        JpaSpecificationExecutor<JobTitle> {

    @Query("SELECT e from JobTitle e where e.active = true ")
    Page<JobTitle> findAllJobTitles(Specification<JobTitle> jobTitleSpecification, Pageable pageable);
}
