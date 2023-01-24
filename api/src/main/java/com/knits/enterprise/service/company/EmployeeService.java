package com.knits.enterprise.service.company;


import com.knits.enterprise.dto.company.EmployeeDto;
import com.knits.enterprise.exceptions.UserException;
import com.knits.enterprise.mapper.company.EmployeeMapper;
import com.knits.enterprise.model.company.Employee;
import com.knits.enterprise.repository.company.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;


    @Transactional
    public EmployeeDto saveNewEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEntity(employeeDto);
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

        @Transactional
        public EmployeeDto findEmployeeById (Long id){
            Employee employee = employeeRepository.findById(id).orElseThrow(() -> new UserException("User#" + id + " not found"));
            return employeeMapper.toDto(employee);
        }


    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getId()).orElseThrow(() -> new UserException("User#" + employeeDto.getId() + " not found"));
        employeeMapper.partialUpdate(employee,employeeDto );
        employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Transactional
    public EmployeeDto deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return employeeMapper.toDto(employee);

    }

    public List<EmployeeDto> findAllByGroupId(Long groupId) {
        return employeeRepository.findAllByGroupId(groupId).stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }
}


