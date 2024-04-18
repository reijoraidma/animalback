package com.lostfound.animalback.domain.animal.animaltype;

import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfo;
import org.mapstruct.*;
import util.StringConverter;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,imports = {StringConverter.class})
public interface AnimalTypeMapper {
    @Named("toAnimalTypeInfo")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(expression = "java(StringConverter.bytesToString(animalType.getImageData()))", target = "imageData")
    AnimalTypeInfo toAnimalTypeInfo(AnimalType animalType);

    @IterableMapping(qualifiedByName = "toAnimalTypeInfo")
    List<AnimalTypeInfo> toAnimalTypeInfos(List<AnimalType> animalTypes);
}





