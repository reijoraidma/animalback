package com.lostfound.animalback.business.animal.animalgender.dto;

import com.lostfound.animalback.domain.animal.animalgender.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Gender}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalGenderInfo implements Serializable {
    private Integer animalGenderId;
    private String animalGenderType;
}