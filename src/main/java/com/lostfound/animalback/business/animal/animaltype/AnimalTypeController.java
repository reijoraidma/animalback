package com.lostfound.animalback.business.animal.animaltype;

import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnimalTypeController
{
    private AnimalTypeService animalTypeService;

    @GetMapping("/animal/animaltypes")
    public List<AnimalTypeInfo> getAnimalTypes() {
       return animalTypeService.getAnimalTypes();
    }

}
