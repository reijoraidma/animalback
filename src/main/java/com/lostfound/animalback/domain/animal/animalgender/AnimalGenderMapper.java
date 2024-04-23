package com.lostfound.animalback.domain.animal.animalgender;

import com.lostfound.animalback.business.animal.animalgender.dto.AnimalGenderInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimalGenderMapper {

    @Named("toAnimalGenderInfo")
    @Mapping(source = "id", target = "animalGenderId")
    @Mapping(source = "type", target = "animalGenderType")
    AnimalGenderInfo toAnimalGenderInfo(Gender animalGender);

    @IterableMapping(qualifiedByName = "toAnimalGenderInfo")
    List<AnimalGenderInfo> toAnimalGenderInfos(List<Gender> animalGenders);
}