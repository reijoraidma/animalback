package com.lostfound.animalback.business.profile;

import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import com.lostfound.animalback.business.profile.dto.ProfileUpdate;
import com.lostfound.animalback.domain.profile.Profile;
import com.lostfound.animalback.domain.profile.ProfileMapper;
import com.lostfound.animalback.domain.profile.ProfileRepository;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;
    private final UserRepository userRepository;

    @Transactional
    public void updateProfile(Integer profileId, ProfileUpdate profileUpdate) {
        Profile profile = getAndUpdateProfile(profileId, profileUpdate);
        updateUserEmail(profileUpdate.getUserEmail(), profile.getUser());
    }

    private Profile getAndUpdateProfile(Integer profileId, ProfileUpdate profileUpdate) {
        Profile profile = profileRepository.getReferenceById(profileId);
        profile.setName(profileUpdate.getName());
        profileRepository.save(profile);
        return profile;
    }

    private void updateUserEmail(String userEmail, User user) {
        user.setEmail(userEmail);
        userRepository.save(user);
    }

    public ProfileInfo getProfile(Integer profileId) {
        ProfileInfo profileInfo = profileMapper.toProfileInfo(profileRepository.getProfile(profileId));
        return profileInfo;
    }


}
