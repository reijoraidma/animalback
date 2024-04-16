package com.lostfound.animalback.business.profile;

import com.lostfound.animalback.business.profile.dto.ImageUpdate;
import com.lostfound.animalback.business.profile.dto.PasswordUpdate;
import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import com.lostfound.animalback.business.profile.dto.ProfileUpdate;
import com.lostfound.animalback.domain.profile.Profile;
import com.lostfound.animalback.domain.profile.ProfileMapper;
import com.lostfound.animalback.domain.profile.ProfileRepository;
import com.lostfound.animalback.domain.role.RoleRepository;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserRepository;
import com.lostfound.animalback.infrastructure.exception.ForbiddenException;
import com.lostfound.animalback.infrastructure.exception.NotFoundException;
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
    private final RoleRepository roleRepository;

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


    public void updateImage(Integer profileId, ImageUpdate imageUpdate) {
        Profile profile = profileRepository.getReferenceById(profileId);
        profile.setImageData(StringConverter.stringToBytes(imageUpdate.getImageData()));
        profileRepository.save(profile);
    }

    public void updatePassword(Integer profileId, PasswordUpdate passwordUpdate) {

        User user = profileRepository.getProfile(profileId).getUser();
        String oldPassword = user.getPassword();

         if(oldPassword.equals(passwordUpdate.getOldPassword())){
             user.setPassword(passwordUpdate.getNewPassword());
             userRepository.save(user);
        }else{
             //throw new NotFoundException(INCORRECT_PASSWORD.getMessage(),INCORRECT_PASSWORD.getErrorCode());
             throw new ForbiddenException(INCORRECT_PASSWORD.getMessage(),INCORRECT_PASSWORD.getErrorCode());
        }
    }

    @Transactional
    public void deleteProfile(Integer profileId,String password) {


        Integer userId = getUserIdBy(profileId);
        if(userRepository.getReferenceById(userId).getPassword().equals(password)){
            profileRepository.deleteById(profileId);
            userRepository.deleteById(userId);
        }else{
            throw new ForbiddenException(INCORRECT_PASSWORD.getMessage(),INCORRECT_PASSWORD.getErrorCode());
        }

    }

    private Integer getUserIdBy(Integer profileId) {
        return profileRepository.getProfile(profileId).getUser().getId();
    }
}
