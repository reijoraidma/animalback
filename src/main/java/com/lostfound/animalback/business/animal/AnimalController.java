package com.lostfound.animalback.business.animal;

import com.lostfound.animalback.business.animal.dto.AnimalInfo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AnimalController {

    private AnimalService animalService;


    @Operation(summary = "Tagastab Looma info")
    @GetMapping("/animal/{animalId}")
    public AnimalInfo getAnimal(@PathVariable Integer animalId) {
        return animalService.getAnimal(animalId);
    }
}
