package com.lostfound.animalback.business.login;

import com.lostfound.animalback.business.login.dto.LoginResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private LoginService loginService;

    @GetMapping("/login")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }
}
