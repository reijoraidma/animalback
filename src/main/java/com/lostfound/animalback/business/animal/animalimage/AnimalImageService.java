package com.lostfound.animalback.business.animal.animalimage;

import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageInfo;
import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageSave;
import com.lostfound.animalback.domain.animal.AnimalRepository;
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
    private final AnimalRepository animalRepository;

    public void saveAnimalImages(Integer animalId, List<AnimalImageSave> animalImageSaves) {
        List<AnimalImage> animalImages = animalImageMapper.toAnimalImages(animalImageSaves);
        for(AnimalImage animalImage:animalImages){
            animalImage.setAnimal(animalRepository.getReferenceById(animalId));
        }
        animalImageRepository.saveAll(animalImages);
    }

    public List<AnimalImageInfo> getAnimalImageInfos(Integer animalId){
        List<AnimalImage> animalImages = animalImageRepository.getAnimalImagesByAnimal_Id(animalId);
        return animalImageMapper.toAnimalImageInfos(animalImages);
    }
}
