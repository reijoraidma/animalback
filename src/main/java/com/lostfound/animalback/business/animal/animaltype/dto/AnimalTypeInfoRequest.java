package com.lostfound.animalback.business.animal.animaltype.dto;

import com.lostfound.animalback.domain.animal.animaltype.AnimalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link AnimalType}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalTypeInfoRequest implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String animalTypeName;
    @NotNull
    private String animalTypeImageData;
}