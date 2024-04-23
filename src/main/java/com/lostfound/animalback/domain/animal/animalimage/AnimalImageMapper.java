package com.lostfound.animalback.domain.animal.animalimage;

import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageInfo;
import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageSave;
import org.mapstruct.*;
import util.StringConverter;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,imports = {StringConverter.class})
public interface AnimalImageMapper {

    @Named("toAnimalImage")
    @Mapping(expression = "java(StringConverter.stringToBytes(animalImageSave.getImageData()))", target = "imageData")
    AnimalImage toAnimalImage(AnimalImageSave animalImageSave);
    @IterableMapping(qualifiedByName = "toAnimalImage")
    List<AnimalImage> toAnimalImages(List<AnimalImageSave> animalImageSaves);

    @Named("toAnimalImageInfo")
    @Mapping(source = "id",target = "id")
    @Mapping(source = "animal.id",target = "animalId")
    @Mapping(expression = "java(StringConverter.bytesToString(animalImage.getImageData()))", target = "imageData")
    AnimalImageInfo toAnimalImageInfo(AnimalImage animalImage);
    @IterableMapping(qualifiedByName = "toAnimalImageInfo")
    List<AnimalImageInfo> toAnimalImageInfos(List<AnimalImage> animalImages);
}