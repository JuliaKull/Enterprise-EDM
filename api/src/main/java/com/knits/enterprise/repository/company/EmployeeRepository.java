package com.knits.enterprise.repository.company;

import com.knits.enterprise.model.company.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByGroupId(Long groupId);


}
