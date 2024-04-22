package com.lostfound.animalback.domain.animal;

import com.lostfound.animalback.business.animal.dto.AnimalInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimalMapper {
    @Named("toAnimalInfo")
    @Mapping(source = "animalType.name", target = "animalType")
    @Mapping(source = "breed.type", target = "breed")
    @Mapping(source = "color", target = "color")
    @Mapping(source = "gender.type", target = "gender")
    @Mapping(source = "size", target = "size")
    @Mapping(source = "age", target = "age")
    AnimalInfo toAnimalInfo(Animal animal);

    @IterableMapping(qualifiedByName = "toAnimalInfo")
    List<AnimalInfo> toAnimalInfos(List<Animal> animals);
}