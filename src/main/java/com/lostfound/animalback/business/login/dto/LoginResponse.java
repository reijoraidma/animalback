package com.lostfound.animalback.business.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {
    private Integer userId;
    private String roleName;
}