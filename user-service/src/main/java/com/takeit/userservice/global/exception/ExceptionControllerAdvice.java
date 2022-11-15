package com.takeit.userservice.global.exception;

import com.takeit.userservice.global.dto.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity handleCustomException(CustomException exception) {
        HttpStatus status = exception.getStatus();
        Result errorResult = exception.getErrorResult();
        log.warn("[CustomException] {}, {}", status, errorResult);

        return ResponseEntity.status(status)
                .body(errorResult);
    }
}
