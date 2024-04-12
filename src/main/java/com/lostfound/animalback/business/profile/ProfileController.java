package com.lostfound.animalback.business.profile;

import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProfileController {
    private ProfileService profileService;

    @PutMapping("/profile/{profileId}")
    public void updateProfile(@PathVariable Integer profileId, @RequestBody ProfileInfo profileInfo) {
        profileService.updateProfile(profileId, profileInfo);
    }

}
