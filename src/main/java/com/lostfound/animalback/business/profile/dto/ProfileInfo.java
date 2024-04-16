package com.lostfound.animalback.business.profile.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ProfileInfo implements Serializable {
    @NotNull
    private String userEmail;
    @NotNull
    @Size(max = 255)
    private String name;

    private String imageData;
}