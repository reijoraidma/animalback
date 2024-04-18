package com.lostfound.animalback.business.animal.animaltype;

import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfo;
import com.lostfound.animalback.domain.animal.animaltype.AnimalType;
import com.lostfound.animalback.domain.animal.animaltype.AnimalTypeMapper;
import com.lostfound.animalback.domain.animal.animaltype.AnimalTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;
    private final AnimalTypeMapper animalTypeMapper;
    public List<AnimalTypeInfo> getAnimalTypes() {

        List<AnimalType> animalTypes = animalTypeRepository.findAnimalTypeByStatus("A");
        return  animalTypeMapper.toAnimalTypeInfos(animalTypes);

    }
}
