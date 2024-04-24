package com.lostfound.animalback.business.animal.animalimage;

import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageInfo;
import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageSave;
import com.lostfound.animalback.domain.animal.animalimage.AnimalImage;
import com.lostfound.animalback.domain.animal.animalimage.AnimalImageMapper;
import com.lostfound.animalback.domain.animal.animalimage.AnimalImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnimalImageService {

    private final AnimalImageMapper animalImageMapper;
    private final AnimalImageRepository animalImageRepository;


    public List<AnimalImageInfo> getAnimalImageInfos(Integer animalId){
        List<AnimalImage> animalImages = animalImageRepository.getAnimalImagesByAnimal_Id(animalId);
        return animalImageMapper.toAnimalImageInfos(animalImages);
    }
}
