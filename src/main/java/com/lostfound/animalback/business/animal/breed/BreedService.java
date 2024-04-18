package com.lostfound.animalback.business.animal.breed;

import com.lostfound.animalback.business.animal.breed.dto.BreedResponse;
import com.lostfound.animalback.business.animal.breed.dto.BreedSave;
import com.lostfound.animalback.domain.animal.breed.Breed;
import com.lostfound.animalback.domain.animal.breed.BreedMapper;
import com.lostfound.animalback.domain.animal.breed.BreedRepository;
import com.lostfound.animalback.infrastructure.exception.ForbiddenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lostfound.animalback.infrastructure.error.Error.BREED_ALREADY_EXISTS;

@AllArgsConstructor
@Service
public class BreedService {
    private final BreedRepository breedRepository;
    private final BreedMapper breedMapper;

    public List<BreedResponse> getBreeds(Integer animalTypeId) {
        List<Breed> breedResponses = breedRepository.getBreedsBy("A", animalTypeId);
        return breedMapper.toBreedResponseList(breedResponses);
    }


    public void addBreed(BreedSave breedSave) {
        Breed breed = breedMapper.toBreed(breedSave);
        if (breedRepository.breedExists(breed.getType(), breed.getAnimalType().getId())) {
            throw new ForbiddenException(BREED_ALREADY_EXISTS.getMessage(), BREED_ALREADY_EXISTS.getErrorCode());
        } else {
            breed.setStatus("A");
            breedRepository.save(breed);
        }
    }


}
