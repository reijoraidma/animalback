package com.lostfound.animalback.business.login;

import com.lostfound.animalback.business.login.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public LoginResponse login(String username, String password) {
        return new LoginResponse(1,"MatiNuude");
    }
}
