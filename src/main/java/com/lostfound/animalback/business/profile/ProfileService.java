package com.lostfound.animalback.business.profile;

import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import com.lostfound.animalback.domain.profile.Profile;
import com.lostfound.animalback.domain.profile.ProfileImageMapper;
import com.lostfound.animalback.domain.profile.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import util.StringConverter;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileImageMapper profileImageMapper;

    public void updateProfile(Integer profileId, ProfileInfo profileInfo) {
        Profile profile = profileRepository.getReferenceById(profileId);
        profile.setImageData(StringConverter.stringToBytes(profileInfo.getImageData()));
        profileRepository.save(profile);
    }
}
