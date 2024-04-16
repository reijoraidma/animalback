package com.lostfound.animalback.business.register;

import com.lostfound.animalback.business.register.dto.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {
    private RegisterService registerService;

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRequest userRequest) {
        registerService.registerUser(userRequest);
    }

}
