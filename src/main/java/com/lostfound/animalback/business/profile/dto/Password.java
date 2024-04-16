package com.lostfound.animalback.business.profile.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.lostfound.animalback.domain.user.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Password implements Serializable {
    @NotNull
    @Size(max = 255)
    private String password;
}