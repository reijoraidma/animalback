package com.lostfound.animalback.business.register;

import com.lostfound.animalback.business.register.dto.UserRequest;
import com.lostfound.animalback.domain.profile.Profile;
import com.lostfound.animalback.domain.profile.ProfileRepository;
import com.lostfound.animalback.domain.role.Role;
import com.lostfound.animalback.domain.role.RoleRepository;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserMapper;
import com.lostfound.animalback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import util.StringConverter;

@Service
@AllArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final ProfileRepository profileRepository;


    public void registerUser(UserRequest userRequest) {
        User user = createAndSaveUser(userRequest);
        createAndSaveProfile(userRequest, user);
    }
    private User createAndSaveUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        setCustomerRole(user);
        userRepository.save(user);
        return user;
    }
    private void setCustomerRole(User user) {
        Role role = roleRepository.findRoleById(2);
        user.setRole(role);
    }
    private void createAndSaveProfile(UserRequest userRequest, User user) {
        Profile profile = new Profile();
        profile.setUser(user);
        handleSetImageData(userRequest, profile);
        profile.setName(userRequest.getName());
        profileRepository.save(profile);
    }

    private static void handleSetImageData(UserRequest userRequest, Profile profile) {
        String imageData = userRequest.getImageData();
        if (!imageData.isEmpty()){
            profile.setImageData(StringConverter.stringToBytes((imageData)));
        }
    }

}
