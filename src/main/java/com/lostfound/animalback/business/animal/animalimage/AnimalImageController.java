package com.lostfound.animalback.business.animal.animalimage;

import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnimalImageController {
    private AnimalImageService animalImageService;

    @GetMapping("/animal/images")
    public List<AnimalImageInfo> getAnimalImageInfos(@RequestParam Integer animalId) {
        return animalImageService.getAnimalImageInfos(animalId);
    }
}
