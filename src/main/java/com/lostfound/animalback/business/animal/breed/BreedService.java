package com.lostfound.animalback.business.animal.breed;

import com.lostfound.animalback.business.animal.breed.dto.BreedResponse;
import com.lostfound.animalback.domain.animal.breed.Breed;
import com.lostfound.animalback.domain.animal.breed.BreedMapper;
import com.lostfound.animalback.domain.animal.breed.BreedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BreedService {
    private final BreedRepository breedRepository;
    private final BreedMapper breedMapper;

    public List<BreedResponse> getBreeds(Integer animalTypeId) {
        List<Breed> breedResponses = breedRepository.getBreedsBy("A", animalTypeId);
        return breedMapper.toBreedResponseList(breedResponses);
    }


}
