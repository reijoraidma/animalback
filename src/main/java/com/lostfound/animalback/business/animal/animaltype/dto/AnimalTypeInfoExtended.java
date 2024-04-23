package com.lostfound.animalback.business.animal.animaltype.dto;

import com.lostfound.animalback.domain.animal.animaltype.AnimalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link AnimalType}
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalTypeInfoExtended extends AnimalTypeInfo implements Serializable {
    private String animalTypeImageData;
}