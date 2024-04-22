package com.lostfound.animalback.domain.animal.animaltype;

import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfo;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfoSave;
import org.mapstruct.*;
import util.StringConverter;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,imports = {StringConverter.class})
public interface AnimalTypeMapper {
    @Named("toAnimalTypeInfo")
    @Mapping(source = "id", target = "animalTypeId")
    @Mapping(source = "name", target = "animalTypeName")
    @Mapping(expression = "java(StringConverter.bytesToString(animalType.getImageData()))", target = "animalTypeImageData")
    AnimalTypeInfo toAnimalTypeInfo(AnimalType animalType);

    @IterableMapping(qualifiedByName = "toAnimalTypeInfo")
    List<AnimalTypeInfo> toAnimalTypeInfos(List<AnimalType> animalTypes);

    @Mapping(source = "name", target = "name")
    @Mapping(expression = "java(StringConverter.stringToBytes(animalTypeInfoSave.getImageData()))", target = "imageData")
    AnimalType toAnimalType(AnimalTypeInfoSave animalTypeInfoSave);
}





