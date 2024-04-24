package com.lostfound.animalback.business.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostFilteringData {

    private String postAnimalSize;
    private String postAnimalColor;
    private String postAnimalAge;
}
