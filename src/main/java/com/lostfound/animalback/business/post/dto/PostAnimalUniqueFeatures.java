package com.lostfound.animalback.business.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostAnimalUniqueFeatures {
    private List<String> animalSizes;
    private List<String> animalAges;
    private List<String> animalColors;
}
