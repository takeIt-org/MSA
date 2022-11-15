package com.takeit.userservice.domain.user.exception;

import com.takeit.userservice.global.exception.CustomException;
import org.springframework.http.HttpStatus;

public class NotExistUserException extends CustomException {
    public NotExistUserException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
