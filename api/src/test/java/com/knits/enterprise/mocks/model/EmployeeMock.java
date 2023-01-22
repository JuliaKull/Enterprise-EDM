package com.knits.enterprise.mocks.model;

import com.knits.enterprise.model.company.Employee;
import com.knits.enterprise.model.company.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMock {

        public static Employee shallowEmployeeMock(Long id) {
            return Employee.builder()
                    .id(id)
                    .firstName("John"+id)
                    .lastName("Doe"+id)
                    .email("john.doe@kehne+nagel.com")
                    .dateOfBirth(LocalDateTime.now().minusYears(24))
                    .gender(Gender.MALE)
                    .startDate(LocalDateTime.now().minusMonths(7))
                    .companyPhone("123456789")
                    .companyMobileNumber("123456789")
                    .build();
        }

        public static List<Employee> shallowEmployeeMockList() {
           List<Employee> mockEmployees = new ArrayList<>();
           for (int i = 0; i < 10; i++) {
               mockEmployees.add(shallowEmployeeMock((long) i));
           }
              return mockEmployees;
        }
}
