package com.knits.enterprise.repository.company;

import com.knits.enterprise.model.company.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
