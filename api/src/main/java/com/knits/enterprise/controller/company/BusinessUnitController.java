package com.knits.enterprise.controller.company;

import com.knits.enterprise.dto.company.BusinessUnitDto;
import com.knits.enterprise.dto.search.BusinessUnitSearchDto;
import com.knits.enterprise.service.company.BusinessUnitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class BusinessUnitController {
       private BusinessUnitService businessUnitService;

    private static final String ENDPOINT_NAME="/business-units";

    @PostMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<BusinessUnitDto> createBusinessUnit(@RequestBody BusinessUnitDto businessUnitDto) {
        log.debug("Http request to create "+ENDPOINT_NAME);
        return ResponseEntity.ok().body(businessUnitService.createBusinessUnit(businessUnitDto));
    }

    @PutMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<BusinessUnitDto> updateBusinessUnit(@RequestBody BusinessUnitDto businessUnitDto) {
        log.debug("Http request to update "+ENDPOINT_NAME);
        return ResponseEntity.ok().body(businessUnitService.updateBusinessUnit(businessUnitDto));
    }

    @PatchMapping(value = ENDPOINT_NAME, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<BusinessUnitDto> partialUpdate(@RequestBody BusinessUnitDto businessUnitDto) {
        log.debug("Http request to partialUpdate "+ENDPOINT_NAME);
        return ResponseEntity.ok().body(businessUnitService.partialUpdate(businessUnitDto));
    }

    @DeleteMapping(value =ENDPOINT_NAME+"/{id}")
    public ResponseEntity<Void> deleteBusinessUnit(@PathVariable Long id) {
        log.debug("Http request to delete "+ENDPOINT_NAME+" : {}", id);
        businessUnitService.deleteBusinessUnit(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = ENDPOINT_NAME+"/search", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<BusinessUnitDto>> getActive(@RequestBody BusinessUnitSearchDto businessUnitSearchDto) {
        log.debug("Http request to search "+ENDPOINT_NAME);
        return ResponseEntity.ok().body(businessUnitService.getActive(businessUnitSearchDto).toList());
    }

    @GetMapping(value = "/search-all", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<BusinessUnitDto>> getAll(@RequestBody BusinessUnitSearchDto businessUnitSearchDto) {
        log.debug("REST request to search "+ENDPOINT_NAME);
        return ResponseEntity.ok().body(businessUnitService.getAll(businessUnitSearchDto).toList());
    }

}
