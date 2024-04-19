package com.lostfound.animalback.business.animal.breed;

import com.lostfound.animalback.business.Status;
import com.lostfound.animalback.business.animal.breed.dto.BreedInfo;
import com.lostfound.animalback.business.animal.breed.dto.BreedRequest;
import com.lostfound.animalback.domain.animal.animaltype.AnimalType;
import com.lostfound.animalback.domain.animal.animaltype.AnimalTypeRepository;
import com.lostfound.animalback.domain.animal.breed.Breed;
import com.lostfound.animalback.domain.animal.breed.BreedMapper;
import com.lostfound.animalback.domain.animal.breed.BreedRepository;
import com.lostfound.animalback.infrastructure.exception.ForbiddenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import util.StringConverter;

import java.util.List;

import static com.lostfound.animalback.business.Status.ACTIVE;
import static com.lostfound.animalback.infrastructure.error.Error.BREED_ALREADY_EXISTS;
import static com.lostfound.animalback.infrastructure.error.Error.BREED_NOT_EXISTING;

@AllArgsConstructor
@Service
public class BreedService {
    private final BreedRepository breedRepository;
    private final BreedMapper breedMapper;
    private final AnimalTypeRepository animalTypeRepository;

    public List<BreedInfo> getAnimalBreeds(Integer animalTypeId) {
        List<Breed> breeds = breedRepository.getBreedsBy(ACTIVE, animalTypeId);
        return breedMapper.toBreedInfos(breeds);
    }

    public void addAnimalBreed(BreedRequest breedRequest) {
        AnimalType animalType = animalTypeRepository.getReferenceById(breedRequest.getAnimalTypeId());
        Breed breed = breedMapper.toBreed(breedRequest);
        breed.setAnimalType(animalType);
        breed.setImageData(StringConverter.stringToBytes(breedRequest.getBreedImageData()));
        if (breedRepository.breedExistsBy(breed.getType(), breed.getAnimalType().getId())) {
            throw new ForbiddenException(BREED_ALREADY_EXISTS.getMessage(), BREED_ALREADY_EXISTS.getErrorCode());
        } else {
            breedRepository.save(breed);
        }
    }

    public void updateBreedStatus(String status, Integer breedId) {
        if (breedRepository.breedIdExists(breedId)) {
            Breed breed = breedRepository.getReferenceById(breedId);
            breed.setStatus(status);
            breedRepository.save(breed);
        } else {
            throw new ForbiddenException(BREED_NOT_EXISTING.getMessage(), BREED_NOT_EXISTING.getErrorCode());
        }
    }

    public void deleteBreed(Integer breedId) {
        Breed breed = breedRepository.getReferenceById(breedId);
        breed.setStatus(Status.DEACTIVATED);
        breedRepository.save(breed);
    }
}
