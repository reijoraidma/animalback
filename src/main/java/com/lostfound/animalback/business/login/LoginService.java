package com.lostfound.animalback.business.login;

import com.lostfound.animalback.business.login.dto.LoginResponse;
import com.lostfound.animalback.domain.profile.ProfileRepository;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserMapper;
import com.lostfound.animalback.domain.user.UserRepository;
import com.lostfound.animalback.infrastructure.validation.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ProfileRepository profileRepository;

    public LoginResponse login(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password);
        User user = ValidationService.getValidExistingUser(optionalUser);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        Integer profileId = profileRepository.getProfileIdBy(user.getId());
        loginResponse.setProfileId(profileId);
        return loginResponse;
    }
}
