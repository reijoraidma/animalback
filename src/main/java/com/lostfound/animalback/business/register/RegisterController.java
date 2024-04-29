package com.lostfound.animalback.business.register;

import com.lostfound.animalback.business.register.dto.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {
    private RegisterService registerService;

    @PostMapping("/register")
    @Operation(summary = "Register new user", description = "Register new user with info (name, email, password, imageData). name, email and password are mandatory")
    @ApiResponse(responseCode = "200", description = "OK")
    public void registerUser(@RequestBody UserRequest userRequest) {
        registerService.registerUser(userRequest);
    }
}
