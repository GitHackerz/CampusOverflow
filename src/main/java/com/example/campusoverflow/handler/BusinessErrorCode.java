package com.example.campusoverflow.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BusinessErrorCode {

    NO_CODE(0, HttpStatus.NOT_IMPLEMENTED, "No code"),
    INCORRECT_CURRENT_PASSWORD(300, HttpStatus.BAD_REQUEST, "Incorrect current password"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, HttpStatus.BAD_REQUEST, "New password does not match"),
    ACCOUNT_LOCKED(302, HttpStatus.LOCKED, "Account locked"),
    ACCOUNT_DISABLED(303, HttpStatus.FORBIDDEN, "Account disabled"),
    BAD_CREDENTIALS(304, HttpStatus.UNAUTHORIZED, "Bad credentials"),
    ;


    private final int code;
    private final String description;
    private final HttpStatus httpStatus;

    BusinessErrorCode(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
