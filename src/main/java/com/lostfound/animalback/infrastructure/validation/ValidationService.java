package com.lostfound.animalback.infrastructure.validation;


import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.infrastructure.exception.ForbiddenException;

import java.util.Optional;

import static com.lostfound.animalback.infrastructure.error.Error.INCORRECT_CREDENTIALS;
import static com.lostfound.animalback.infrastructure.error.Error.INCORRECT_PASSWORD;
import static com.lostfound.animalback.infrastructure.error.Error.ANIMAL_TYPE_UNAVAILABLE;

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

    public static void validateAnimalTypeAvailable(boolean animalTypeExists) {
        if (animalTypeExists) {
            throw new ForbiddenException(ANIMAL_TYPE_UNAVAILABLE.getMessage(), ANIMAL_TYPE_UNAVAILABLE.getErrorCode());
        }
    }

}
