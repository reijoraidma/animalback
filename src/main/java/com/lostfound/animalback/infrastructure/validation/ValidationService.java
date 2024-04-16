package com.lostfound.animalback.infrastructure.validation;


import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.infrastructure.exception.ForbiddenException;

import java.util.Optional;

import static com.lostfound.animalback.infrastructure.error.Error.INCORRECT_CREDENTIALS;
import static com.lostfound.animalback.infrastructure.error.Error.INCORRECT_PASSWORD;

public class ValidationService {

    public static User getValidExistingUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new ForbiddenException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateCorrectPassword(String validationPassword, String userPassword) {
        if (!userPassword.equals(validationPassword)) {
            throw new ForbiddenException(INCORRECT_PASSWORD.getMessage(), INCORRECT_PASSWORD.getErrorCode());
        }
    }

}
