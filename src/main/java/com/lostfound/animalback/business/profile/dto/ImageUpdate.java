package com.lostfound.animalback.business.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.lostfound.animalback.domain.profile.Profile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageUpdate implements Serializable {
    private String imageData;
}