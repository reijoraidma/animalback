package com.lostfound.animalback.business.animal.dto;

import com.lostfound.animalback.domain.animal.Animal;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Animal}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalInfo implements Serializable {
    private String animalType;
    private String gender;
    private String breed;
    @Size(max = 255)
    private String size;
    @Size(max = 255)
    private String age;
    @Size(max = 255)
    private String color;
}