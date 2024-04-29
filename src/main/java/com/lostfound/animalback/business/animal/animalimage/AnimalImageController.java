package com.lostfound.animalback.business.animal.animalimage;

import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageSave;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnimalImageController {
    private final AnimalImageService animalImageService;

    @PostMapping("/animals/{animalId}/animalImages")
    @Operation(summary = "Save animal images", description = "Save a list of animal images imageData by animal id")
    @ApiResponse(responseCode = "200", description = "OK")
    public void saveAnimalImages(@PathVariable Integer animalId, @RequestBody List<AnimalImageSave> animalImages) {
        animalImageService.saveAnimalImages(animalId, animalImages);
    }

    @GetMapping("/animal/images")
    @Operation(summary = "Get animal images", description = "Get a list of animal images imageData by animal id")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<AnimalImageInfo> getAnimalImageInfos(@RequestParam Integer animalId) {
        return animalImageService.getAnimalImageInfos(animalId);
    }

}
