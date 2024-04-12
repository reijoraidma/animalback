package com.lostfound.animalback.business.profile;

import com.lostfound.animalback.business.profile.dto.ProfileImageInfo;
import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import com.lostfound.animalback.domain.profile.Profile;
import com.lostfound.animalback.domain.profile.ProfileImageMapper;
import com.lostfound.animalback.domain.profile.ProfileMapper;
import com.lostfound.animalback.domain.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import util.StringConverter;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public void updateProfile(Integer profileId, ProfileImageInfo profileImageInfo) {
        Profile profile = profileRepository.getReferenceById(profileId);
        profile.setImageData(StringConverter.stringToBytes(profileImageInfo.getImageData()));
        profileRepository.save(profile);
    }

    public ProfileInfo getProfile(Integer profileId) {
        ProfileInfo profileInfo = profileMapper.toProfileInfo(profileRepository.getProfileInfo(profileId));
        return profileInfo;
    }
}
