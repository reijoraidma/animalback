package com.lostfound.animalback.infrastructure.exception;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private final String message;
    private final Integer errorCode;

    public NotFoundException(String message, Integer errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
