package com.knits.enterprise.controller;
import com.knits.enterprise.controller.company.EmployeeController;
import com.knits.enterprise.mapper.company.EmployeeMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Captor;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
    @Spy
    private EmployeeController employeeController;

    @Captor
    private EmployeeMapper employeeMapper;
}
