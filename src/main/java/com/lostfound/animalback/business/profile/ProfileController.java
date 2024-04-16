package com.lostfound.animalback.business.profile;

import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import com.lostfound.animalback.business.profile.dto.ProfileUpdate;
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

    @PatchMapping("/profile/{profileId}")
    public void updateProfile(@PathVariable Integer profileId, @RequestBody ProfileUpdate profileUpdate) {
        profileService.updateProfile(profileId, profileUpdate);
    }

    @PatchMapping("/profile/{profileId}/image")
    public void updateProfileImage(@PathVariable Integer profileId, @RequestBody ImageUpdate imageUpdate) {
        profileService.updateImage(profileId, imageUpdate);
    }

}
