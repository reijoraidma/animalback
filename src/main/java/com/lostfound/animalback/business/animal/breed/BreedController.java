package com.lostfound.animalback.business.animal.breed;

import com.lostfound.animalback.business.animal.breed.dto.BreedResponse;
import com.lostfound.animalback.business.animal.breed.dto.BreedSave;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BreedController {
    private BreedService breedService;

    @Operation(summary = "Tagastab listi  tõugudest")
    @GetMapping("/animal/breeds")
    public List<BreedResponse> getBreeds(@RequestParam Integer animalTypeId) {
        return breedService.getBreeds(animalTypeId);
    }

    @Operation(summary = "Lisab uued tõu")
    @PostMapping("/animal/breed")
    public void addBreed(@RequestBody BreedSave breedSave) {
        breedService.addBreed(breedSave);
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


