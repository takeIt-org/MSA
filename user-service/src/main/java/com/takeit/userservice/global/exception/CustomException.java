package com.takeit.userservice.global.exception;

import com.takeit.userservice.global.dto.Result;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private HttpStatus status;
    private Result errorResult;

    protected CustomException(HttpStatus status, String message) {
        this.status = status;
        this.errorResult = Result.createErrorResult(message);
    }
}
