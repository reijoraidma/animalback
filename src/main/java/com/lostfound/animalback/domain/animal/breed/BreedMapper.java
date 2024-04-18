package com.lostfound.animalback.domain.animal.breed;

import com.lostfound.animalback.business.animal.breed.dto.BreedResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BreedMapper {

    @Named("toBreedResponse")
    @Mapping(source = "type", target = "type")
    BreedResponse toBreedResponse(Breed breed);

    @IterableMapping(qualifiedByName = "toBreedResponse")
    List<BreedResponse> toBreedResponseList(List<Breed> breeds);


}