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
public class AnimalImageSave implements Serializable {
    @NotNull
    private String imageData;
}