package com.lostfound.animalback.business.animal.animaltype.dto;

import com.lostfound.animalback.domain.animal.animaltype.AnimalType;
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
public class AnimalTypeInfo implements Serializable {
    private Integer animalTypeId;
    private String animalTypeName;
    private String animalTypeStatus;
}