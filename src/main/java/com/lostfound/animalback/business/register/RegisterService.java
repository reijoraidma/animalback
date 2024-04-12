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

@Service
@AllArgsConstructor
public class RegisterService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ProfileRepository profileRepository;
    private final RoleRepository roleRepository;


    public void registerUser(UserRequest userRequest) {
        User user = createAndSaveUser(userRequest);
        createAndSaveProfile(userRequest, user);
    }

    private User createAndSaveUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        setUserRoleAsCustomer(user);
        return userRepository.save(user);
    }

    private void setUserRoleAsCustomer(User user) {
        Role role = roleRepository.findRoleById(2);
        user.setRole(role);
    }

    private void createAndSaveProfile(UserRequest userRequest, User user) {
        Profile profile = new Profile();
        profile.setUser(user);
        profile.setName(userRequest.getName());
        profileRepository.save(profile);
    }
}
