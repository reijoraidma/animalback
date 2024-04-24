package com.lostfound.animalback.business.animal.animalimage.dto;

import com.lostfound.animalback.domain.animal.animalimage.AnimalImage;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link AnimalImage}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalImageInfo implements Serializable {

    private Integer animalImageId;
    private String imageData;
}