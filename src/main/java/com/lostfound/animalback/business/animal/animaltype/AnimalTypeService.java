package com.lostfound.animalback.business.animal.animaltype;

import com.lostfound.animalback.business.Status;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfo;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfoSave;
import com.lostfound.animalback.domain.animal.animaltype.AnimalType;
import com.lostfound.animalback.domain.animal.animaltype.AnimalTypeMapper;
import com.lostfound.animalback.domain.animal.animaltype.AnimalTypeRepository;
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
    public List<AnimalTypeInfo> getAnimalTypes() {

        List<AnimalType> animalTypes = animalTypeRepository.findAnimalTypeByStatus(Status.ACTIVE);
        return  animalTypeMapper.toAnimalTypeInfos(animalTypes);

    }

    @Transactional
    public AnimalTypeInfo addAnimalType(AnimalTypeInfoSave animalTypeInfoSave) {
        String formattedAnimalTypeName = formatAndHandleExistingAnimalTypeInsert(animalTypeInfoSave);
        animalTypeInfoSave.setName(formattedAnimalTypeName);
        AnimalType animalType = createEntity(animalTypeInfoSave);
        animalType = deactivateAndSaveNewAnimalType(animalType);
        return animalTypeMapper.toAnimalTypeInfo(animalType);
    }

    private AnimalType deactivateAndSaveNewAnimalType(AnimalType animalType) {
        animalType.setStatus(Status.DEACTIVATED);
        animalType = animalTypeRepository.save(animalType);
        return animalType;
    }

    private AnimalType createEntity(AnimalTypeInfoSave animalTypeInfoSave) {
        return animalTypeMapper.toAnimalType(animalTypeInfoSave);
    }

    private String formatAndHandleExistingAnimalTypeInsert(AnimalTypeInfoSave animalTypeInfoSave) {
        String formattedAnimalTypeName = formatAnimalType(animalTypeInfoSave.getName());
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
