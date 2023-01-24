package com.knits.enterprise.controller.company;

import com.knits.enterprise.dto.company.EmployeeDto;
import com.knits.enterprise.service.company.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    private static final String ENDPOINT_NAME = "/employees";


    private EmployeeService employeeService;

    @PostMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody EmployeeDto employeeDto) {
        log.debug("REST request to create Employee");
        return ResponseEntity
                .ok()
                .body(employeeService.saveNewEmployee(employeeDto));
    }

    @GetMapping(value = ENDPOINT_NAME+"/{id}", produces = {"application/json"} )
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "id") final Long id) {
        log.debug("REST request to get Employee : {}", id);
        EmployeeDto employeeFound = employeeService.findEmployeeById(id);
        return ResponseEntity
                .ok()
                .body(employeeFound);
    }

    @PatchMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<EmployeeDto> partialUpdateEmployee(@PathVariable(value = "id") @RequestBody EmployeeDto employeeDto) {
        log.debug("REST request to partially update Employee by id : {}", id);
        EmployeeDto employeeFound = employeeService.updateEmployee(employeeDto);
        return ResponseEntity
                .ok()
                .body(employeeFound);
    }

    @PutMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(value = "id") @RequestBody EmployeeDto employeeDto) {
        log.debug("REST request to partially update Employee by id : {}", id);
        EmployeeDto employeeFound = employeeService.updateEmployee(employeeDto);
        return ResponseEntity
                .ok()
                .body(employeeFound);
    }



    @DeleteMapping(value = ENDPOINT_NAME, produces = {"application/json"})
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable(value = "id") final Long id) {
        log.debug("REST request to delete Employee : {}", id);
        EmployeeDto employeeFound = employeeService.deleteEmployee(id);
        return ResponseEntity
                .ok()
                .body(employeeFound);
    }

}
