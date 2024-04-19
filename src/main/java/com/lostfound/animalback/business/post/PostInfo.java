package com.lostfound.animalback.business.post;

import com.lostfound.animalback.domain.post.Post;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInfo implements Serializable {
    @NotNull
    private Integer id;
    private Integer userId;
    private Integer animalId;
    private Integer animalAnimalTypeId;
    private String animalAnimalTypeName;
    private String animalAnimalTypeImageData;
    private String animalAnimalTypeStatus;
    private Integer animalGenderId;
    private String animalGenderType;
    private Integer animalBreedId;
    private String animalBreedType;
    private String animalBreedStatus;
    private String animalSize;
    private String animalAge;
    private String animalColor;
    @NotNull
    private String type;
    @NotNull
    private String status;
    @NotNull
    private Integer timestamp;
    @Size(max = 255)
    private String city;
    @Size(max = 255)
    private String county;
    @Size(max = 255)
    private String address;
    @Size(max = 255)
    private String info;
}