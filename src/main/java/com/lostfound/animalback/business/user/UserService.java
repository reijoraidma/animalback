package com.lostfound.animalback.business.user;

import com.lostfound.animalback.business.Status;
import com.lostfound.animalback.business.user.dto.PasswordUpdate;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserRepository;
import com.lostfound.animalback.infrastructure.exception.ForbiddenException;
import com.lostfound.animalback.infrastructure.validation.ValidationService;
import org.springframework.stereotype.Service;

import static com.lostfound.animalback.infrastructure.error.Error.INCORRECT_PASSWORD;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUserPassword(Integer userId, PasswordUpdate passwordUpdate) {
        User user = userRepository.getReferenceById(userId);
        String oldPassword = user.getPassword();
        if (oldPassword.equals(passwordUpdate.getOldPassword())) {
            user.setPassword(passwordUpdate.getNewPassword());
            userRepository.save(user);
        } else {
            throw new ForbiddenException(INCORRECT_PASSWORD.getMessage(), INCORRECT_PASSWORD.getErrorCode());
        }
    }

    public void deleteUser(Integer userId, String validationPassword) {
        User user = userRepository.getReferenceById(userId);
        ValidationService.validateCorrectPassword(validationPassword, user.getPassword());
        user.setStatus(Status.DEACTIVATED);
        userRepository.save(user);
    }



}
