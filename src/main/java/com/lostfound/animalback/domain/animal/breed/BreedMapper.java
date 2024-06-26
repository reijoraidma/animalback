package com.lostfound.animalback.domain.animal.breed;

import com.lostfound.animalback.business.Status;
import com.lostfound.animalback.business.animal.breed.dto.BreedInfo;
import com.lostfound.animalback.business.animal.breed.dto.BreedRequest;
import org.mapstruct.*;
import util.StringConverter;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,imports = {StringConverter.class})
public interface BreedMapper {

    @Named("toBreedResponse")
    @Mapping(source = "type", target = "breedName")
    @Mapping(source = "id", target = "breedId")
    @Mapping(expression = "java(StringConverter.bytesToString(breed.getImageData()))", target = "breedImageData")
    BreedInfo toBreedInfo(Breed breed);

    @IterableMapping(qualifiedByName = "toBreedResponse")
    List<BreedInfo> toBreedInfos(List<Breed> breeds);

    @Mapping(source = "breedName", target = "type")
    @Mapping(constant = Status.ACTIVE, target = "status")
    Breed toBreed(BreedRequest breedRequest);

}