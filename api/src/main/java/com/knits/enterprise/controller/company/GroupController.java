package com.knits.enterprise.controller.company;


import com.knits.enterprise.dto.company.EmployeeDto;
import com.knits.enterprise.dto.company.GroupDto;
import com.knits.enterprise.service.company.EmployeeService;
import com.knits.enterprise.service.company.GroupService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class GroupController {

    private static final String ENDPOINT_NAME = "/groups";

    private final GroupService groupService;

    private final EmployeeService employeeService;


    @PostMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupDto groupDto) {
        log.debug("REST request to create Group");
        return ResponseEntity.ok()
                .body(groupService.createGroup(groupDto));
    }


    @GetMapping(value = ENDPOINT_NAME+"/id", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<GroupDto> getGroupById(@PathVariable(value = "id") final Long id) {
        log.debug("REST request to get Group : {}", id);
        GroupDto groupFound = groupService.findById(id);
        return ResponseEntity
                .ok()
                .body(groupFound);
    }

    @PatchMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<GroupDto> updateGroup(@PathVariable(value = "id") @RequestBody GroupDto groupDto) {
        GroupDto groupFound = groupService.updateGroup(groupDto);
        return ResponseEntity
                .ok()
                .body(groupFound);
    }

    @PutMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<GroupDto> deleteGroup(@PathVariable(value = "id") final Long id) {
        log.debug("REST request to delete Group : {}", id);
        GroupDto groupFound = groupService.deleteGroup(id);
        return ResponseEntity
                .ok()
                .body(groupFound);
    }

    @GetMapping(value = ENDPOINT_NAME+"/employee", produces = {"application/json"})
    public ResponseEntity<List<EmployeeDto>> getAll(@PathVariable(value = "id") final Long id) {
        log.debug("REST request to get all Employees by Group id : {}", id);
        return ResponseEntity
                .ok()
                .body(employeeService.findAllByGroupId(id));
    }
}
