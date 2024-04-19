package com.lostfound.animalback.business.location;

import com.lostfound.animalback.business.animal.dto.AnimalInfo;
import com.lostfound.animalback.domain.location.LocationRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @Operation(summary = "Tagastab Asukoha info")
    @GetMapping("/post/{postId}/location")
    public AnimalInfo getLocation(@PathVariable Integer postId) {
        return locationService.getLocation(postId);
    }
}

