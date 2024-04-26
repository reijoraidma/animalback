package com.lostfound.animalback.business.animal.breed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.lostfound.animalback.domain.animal.breed.Breed}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BreedInfo implements Serializable {
    private Integer breedId;
    private String breedName;
    private String breedImageData;
}