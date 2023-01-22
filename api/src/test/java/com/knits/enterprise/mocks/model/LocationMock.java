package com.knits.enterprise.mocks.model;

import com.knits.enterprise.model.location.Location;
import com.knits.enterprise.model.enums.OwnershipType;
import com.knits.enterprise.model.enums.LocationUsageType;

import java.util.ArrayList;
import java.util.List;

public class LocationMock {

    public static Location shallowLocation(Long id){

        return Location.builder()
                .id(id)
                .name("A mock Name")
                .zipCode("A mock zipCode")
                .mapCoordinates(false)
                .latitude("A mock Latitude")
                .longitude("A mock Longitude")
                .ownership(OwnershipType.OUR_PREMISES)
                .realEstate(LocationUsageType.OFFICE)
                .isDeleted(false)
                .build();
    }

    public static List<Location> shallowListOfLocation(int howMany){
        List<Location> mockLocations = new ArrayList<>();
        for (int i=0;i<howMany; i++){
            mockLocations.add(shallowLocation(Long.valueOf(i)));
        }
        return mockLocations;
    }
}
