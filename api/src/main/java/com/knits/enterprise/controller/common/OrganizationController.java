package com.knits.enterprise.controller.common;


import com.knits.enterprise.dto.common.OrganizationDto;
import com.knits.enterprise.dto.search.OrganizationSearchDto;
import com.knits.enterprise.service.common.OrganizationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class OrganizationController {

    private final OrganizationService organizationService;


    @PostMapping(value = "/organizations", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> createOrganization(@RequestBody OrganizationDto organizationDto){
        log.debug("REST request to create Organization");
        return ResponseEntity.ok()
                .body(organizationService.save(organizationDto));
    }

    @PutMapping(value = "/organizations", produces = {"application/json"}, consumes = { "application/json"})
    public ResponseEntity<OrganizationDto> partialUpdateOrganization(@RequestBody OrganizationDto organizationDto){
        log.debug("REST request to update Organization");
        return ResponseEntity.ok()
                .body(organizationService.partialUpdate(organizationDto));
    }

    @GetMapping(value = "/organizations")
    public ResponseEntity<List<OrganizationDto>> searchOrganization(OrganizationSearchDto searchDto ){
        log.debug("request to search organization");
        return ResponseEntity.ok()
                .body(organizationService.search(searchDto).toList());
    }

    @DeleteMapping("/organizations/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id){
        log.debug("REST request to delete Organization : {}", id);
        organizationService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

