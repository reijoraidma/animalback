package com.lostfound.animalback.business.animal.animalgender;

import com.lostfound.animalback.business.animal.animalgender.dto.AnimalGenderInfo;
import com.lostfound.animalback.domain.animal.animalgender.AnimalGenderMapper;
import com.lostfound.animalback.domain.animal.animalgender.AnimalGenderRepository;
import com.lostfound.animalback.domain.animal.animalgender.Gender;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalGenderService {
    private final AnimalGenderRepository animalGenderRepository;
    private final AnimalGenderMapper animalGenderMapper;
    public List<AnimalGenderInfo> getAnimalGenders() {
        List<Gender> animalGenders = animalGenderRepository.findAll();
        return animalGenderMapper.toAnimalGenderInfos(animalGenders);
    }
}
