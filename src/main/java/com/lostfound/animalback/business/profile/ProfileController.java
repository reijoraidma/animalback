package com.lostfound.animalback.business.profile;

import com.lostfound.animalback.business.profile.dto.ProfileImageInfo;
import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProfileController {
    private ProfileService profileService;

    @GetMapping("/profile/{profileId}")
    public ProfileInfo getProfile(@PathVariable Integer profileId) {
        return profileService.getProfile(profileId);
    }












    @PutMapping("/profile/{profileId}")
    public void updateProfile(@PathVariable Integer profileId, @RequestBody ProfileImageInfo profileImageInfo) {
        profileService.updateProfile(profileId, profileImageInfo);
    }

}
