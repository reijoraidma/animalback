package com.lostfound.animalback.business.login.dto;

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
public class LoginResponse implements Serializable {
    String userId;
    String roleName;
}