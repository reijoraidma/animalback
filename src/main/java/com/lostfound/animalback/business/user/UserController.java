package com.lostfound.animalback.business.user;

import com.lostfound.animalback.business.user.dto.PasswordUpdate;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @PatchMapping("/user/{userId}/password")
    public void updateUserPassword(@PathVariable Integer userId, @RequestBody PasswordUpdate passwordUpdate) {
        userService.updateUserPassword(userId, passwordUpdate);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Integer userId , @RequestParam String validationPassword) {
        userService.deleteUser(userId, validationPassword);
    }
}
