package com.lostfound.animalback.business.profile;

import com.lostfound.animalback.business.profile.dto.ImageUpdate;
import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import com.lostfound.animalback.business.profile.dto.ProfileUpdate;
import com.lostfound.animalback.domain.profile.Profile;
import com.lostfound.animalback.domain.profile.ProfileMapper;
import com.lostfound.animalback.domain.profile.ProfileRepository;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserRepository;
import com.lostfound.animalback.infrastructure.exception.ForbiddenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.StringConverter;

import static com.lostfound.animalback.infrastructure.error.Error.INCORRECT_PASSWORD;

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
        Profile profile = profileRepository.getReferenceById(profileId);
        return profileMapper.toProfileInfo(profile);
    }


    public void updateImage(Integer profileId, ImageUpdate imageUpdate) {
        Profile profile = profileRepository.getReferenceById(profileId);
        profile.setImageData(StringConverter.stringToBytes(imageUpdate.getImageData()));
        profileRepository.save(profile);
    }



    @Transactional
    public void deleteProfile(Integer profileId, String password) {
        int userId = getUserIdBy(profileId);
        if (userRepository.getReferenceById(userId).getPassword().equals(password)) {
            profileRepository.deleteById(profileId);
            deleteUser(userId);
        } else {
            throw new ForbiddenException(INCORRECT_PASSWORD.getMessage(), INCORRECT_PASSWORD.getErrorCode());
        }

    }

    private int getUserIdBy(Integer profileId) {
        return profileRepository.getReferenceById(profileId).getUser().getId();
    }

    private void deleteUser(int userId) {
        User user = userRepository.getReferenceById(userId);
        userRepository.deleteUserBy(user.getId());
    }
}
