package com.lostfound.animalback.domain.animal.animaltype;

import com.lostfound.animalback.business.Status;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfo;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfoExtended;
import com.lostfound.animalback.business.animal.animaltype.dto.AnimalTypeInfoRequest;
import org.mapstruct.*;
import util.StringConverter;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,imports = {StringConverter.class})
public interface AnimalTypeMapper {
    @Named("toAnimalTypeInfo")
    @Mapping(source = "id", target = "animalTypeId")
    @Mapping(source = "name", target = "animalTypeName")
    @Mapping(source = "status", target = "animalTypeStatus")
    AnimalTypeInfo toAnimalTypeInfos(AnimalType animalType);

    @IterableMapping(qualifiedByName = "toAnimalTypeInfo")
    List<AnimalTypeInfo> toAnimalTypeInfos(List<AnimalType> animalType);

    @Named("toAnimalTypeInfoExtended")
    @Mapping(source = "id", target = "animalTypeId")
    @Mapping(source = "name", target = "animalTypeName")
    @Mapping(expression = "java(StringConverter.bytesToString(animalType.getImageData()))", target = "animalTypeImageData")
    @Mapping(source = "status", target = "animalTypeStatus")
    AnimalTypeInfoExtended toAnimalTypeInfoExtended(AnimalType animalType);

    @IterableMapping(qualifiedByName = "toAnimalTypeInfoExtended")
    List<AnimalTypeInfoExtended> toAnimalTypeInfosExtended(List<AnimalType> animalTypes);

    @Mapping(source = "animalTypeName", target = "name")
    @Mapping(constant = Status.PENDING, target = "status")
    @Mapping(expression = "java(StringConverter.stringToBytes(animalTypeInfoRequest.getAnimalTypeImageData()))", target = "imageData")
    AnimalType toAnimalType(AnimalTypeInfoRequest animalTypeInfoRequest);
}





