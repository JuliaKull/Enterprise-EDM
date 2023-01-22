package com.knits.enterprise.repository.company;

import com.knits.enterprise.model.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

