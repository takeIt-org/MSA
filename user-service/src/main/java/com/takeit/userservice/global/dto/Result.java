package com.takeit.userservice.global.dto;

import static com.takeit.userservice.global.dto.Code.*;
import static lombok.AccessLevel.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
public class Result<T> {
    private static final String EMPTY_MESSAGE = "";
    private Code code;
    private String message;
    private T data;

    @Builder(access = PRIVATE)
    private Result(Code code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result createSuccessResult(T data) {
        return Result.builder()
                .code(SUCCESS)
                .message(EMPTY_MESSAGE)
                .data(data)
                .build();
    }

    public static Result createErrorResult(String message) {
        return Result.builder()
                .code(ERROR)
                .message(message)
                .data(null)
                .build();
    }
}
