package com.lostfound.animalback.business.animal.animalimage;

import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageSave;
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
    public void saveAnimalImages(@PathVariable Integer animalId, @RequestBody List<AnimalImageSave> animalImages) {
        animalImageService.saveAnimalImages(animalId, animalImages);
    }

    @GetMapping("/animal/images")
    public List<AnimalImageInfo> getAnimalImageInfos(@RequestParam Integer animalId) {
        return animalImageService.getAnimalImageInfos(animalId);
    }

}
