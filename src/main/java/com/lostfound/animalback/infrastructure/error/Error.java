package com.lostfound.animalback.infrastructure.error;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),
    INCORRECT_PASSWORD("Vale parool", 333),
    ANIMAL_TYPE_UNAVAILABLE("Sellise nimega looma liik on juba süsteemis olemas", 409);



    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
