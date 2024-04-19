package com.lostfound.animalback.domain.animal;

import com.lostfound.animalback.business.animal.dto.AnimalInfo;
import com.lostfound.animalback.domain.Animal;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimalMapper {
    @Mapping(source = "animalType.name", target = "animalType")
    @Mapping(source = "breed.type", target = "breed")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "gender.type", target = "gender")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "age", target = "age")
    AnimalInfo toAnimalInfo(Animal animal);
}