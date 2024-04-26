package com.lostfound.animalback.business.post.dto;

import com.lostfound.animalback.domain.post.Post;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    @NotNull
    private String postType;
    @NotNull
    private Integer userId;
    @NotNull
    private Integer animalTypeId;
    private Integer animalBreedId;
    private Integer animalGenderId;
    private String animalSize;
    private String animalAge;
    private String animalColor;
    @Size(max = 255)
    private String title;
    @Size(max = 255)
    private String city;
    @Size(max = 255)
    private String county;
    @Size(max = 255)
    private String address;
    @Size(max = 255)
    private String info;
    @NotNull
    private String postAnimalImageData;
}
