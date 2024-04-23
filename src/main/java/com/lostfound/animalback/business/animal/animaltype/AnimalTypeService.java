package com.lostfound.animalback.business.animal.animaltype;

import com.lostfound.animalback.business.Status;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfo;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfoExtended;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfoRequest;
import com.lostfound.animalback.domain.animal.animaltype.AnimalType;
import com.lostfound.animalback.domain.animal.animaltype.AnimalTypeMapper;
import com.lostfound.animalback.domain.animal.animaltype.AnimalTypeRepository;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserRepository;
import com.lostfound.animalback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.StringConverter;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;
    private final AnimalTypeMapper animalTypeMapper;
    private final UserRepository userRepository;

    public List<AnimalTypeInfo> getAnimalTypes(Integer userId) {
        List<AnimalType> animalTypes = animalTypeRepository.findAnimalTypesByEither(Status.ACTIVE, userId);
        return animalTypeMapper.toAnimalTypeInfos(animalTypes);
    }


    public List<AnimalTypeInfoExtended> getExtendedAnimalTypes(Integer userId) {
        List<AnimalType> animalTypes = animalTypeRepository.findAnimalTypesByEither(Status.ACTIVE, userId);
        return animalTypeMapper.toAnimalTypeInfosExtended(animalTypes);
    }

    @Transactional
    public Integer addAnimalType(AnimalTypeInfoRequest animalTypeInfoRequest) {
        String formattedAnimalTypeName = formatAndHandleExistingAnimalTypeInsert(animalTypeInfoRequest);
        animalTypeInfoRequest.setAnimalTypeName(formattedAnimalTypeName);

        User user = userRepository.getReferenceById(animalTypeInfoRequest.getUserId());
        AnimalType animalType = animalTypeMapper.toAnimalType(animalTypeInfoRequest);
        animalType.setUser(user);
        animalType = animalTypeRepository.save(animalType);
        return animalType.getId();

    }

    private AnimalType deactivateAndSaveNewAnimalType(AnimalType animalType) {

        return animalType;
    }

    private AnimalType createAnimalType(AnimalTypeInfoRequest animalTypeInfoRequest) {
        return animalTypeMapper.toAnimalType(animalTypeInfoRequest);
    }

    private String formatAndHandleExistingAnimalTypeInsert(AnimalTypeInfoRequest animalTypeInfoRequest) {
        String formattedAnimalTypeName = formatAnimalType(animalTypeInfoRequest.getAnimalTypeName());
        handleAnimalTypeAvailabilityValidation(formattedAnimalTypeName);
        return formattedAnimalTypeName;
    }

    private void handleAnimalTypeAvailabilityValidation(String animalType) {

        boolean animalTypeExists = animalTypeRepository.existsAnimalTypeByName(animalType);
        ValidationService.validateAnimalTypeAvailable(animalTypeExists);
    }

    private static String formatAnimalType(String animalType) {
        return StringConverter.uppercaseAllLettersRemoveWhitespace(animalType);
    }
}
