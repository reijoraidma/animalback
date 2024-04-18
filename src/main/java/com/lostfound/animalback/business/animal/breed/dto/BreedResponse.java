package com.lostfound.animalback.business.animal.breed.dto;

import jakarta.validation.constraints.Size;
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
public class BreedResponse implements Serializable {
    @Size(max = 255)
    private String type;
    }