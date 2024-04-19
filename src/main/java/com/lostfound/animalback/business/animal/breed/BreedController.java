package com.lostfound.animalback.business.animal.breed;

import com.lostfound.animalback.business.animal.breed.dto.BreedInfo;
import com.lostfound.animalback.business.animal.breed.dto.BreedRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BreedController {
    private BreedService breedService;

    @Operation(summary = "Tagastab listi  tõugudest")
    @GetMapping("/animal/breeds")
    public List<BreedInfo> getAnimalBreeds(@RequestParam Integer animalTypeId) {
        return breedService.getAnimalBreeds(animalTypeId);
    }

    @Operation(summary = "Lisab uued tõu")
    @PostMapping("/animal/breed")
    public void addAnimalBreed(@RequestBody @Valid BreedRequest breedRequest) {
        breedService.addAnimalBreed(breedRequest);
    }

    @Operation(summary = "Muudab tõu staatuse")
    @PatchMapping("/animal/breed")
    public void updateBreedStatus(@RequestParam String status, @RequestParam Integer breedId) {
        breedService.updateBreedStatus(status, breedId);
    }

    @Operation(summary = "Kustutab tõu")
    @DeleteMapping("/animal/breed")
    public void deleteBreed(@RequestParam Integer breedId) {
        breedService.deleteBreed(breedId);
    }
}


