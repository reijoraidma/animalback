package com.lostfound.animalback.business.post.dto;

import com.lostfound.animalback.domain.animal.animalimage.AnimalImage;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.lostfound.animalback.domain.post.Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInfo implements Serializable {
    private String animalTypeName;
    private String animalGenderType;
    private String animalBreedType;
    private String animalSize;
    private String animalAge;
    private String animalColor;
    private String county;
    private Integer animalId;
}