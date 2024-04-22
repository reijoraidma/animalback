package com.lostfound.animalback.business.animal;

import com.lostfound.animalback.business.animal.dto.AnimalInfo;
import com.lostfound.animalback.domain.animal.Animal;
import com.lostfound.animalback.domain.animal.AnimalMapper;
import com.lostfound.animalback.domain.animal.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;

    public AnimalInfo getAnimal(Integer animalId) {
        Animal animal = animalRepository.getReferenceById(animalId);
        return animalMapper.toAnimalInfo(animal);
    }

}
