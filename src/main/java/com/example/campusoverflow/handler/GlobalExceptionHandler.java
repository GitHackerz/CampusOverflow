package com.example.campusoverflow.handler;

import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.exceptions.UnAuthorizedException;
import com.example.campusoverflow.exceptions.AlreadyExistsException;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Set;

import static com.example.campusoverflow.handler.BusinessErrorCode.*;
import static com.example.campusoverflow.handler.BusinessErrorCode.NOT_FOUND;
import static com.example.campusoverflow.handler.BusinessErrorCode.UNAUTHORIZED;
import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<ExceptionResponse> handleException(LockedException exp){
        return ResponseEntity
                .status(ACCOUNT_LOCKED.getHttpStatus())
                .body(ExceptionResponse.builder()
                        .businessErrorCode(ACCOUNT_LOCKED.getHttpStatus().value())
                        .businessExceptionDescription(ACCOUNT_LOCKED.getDescription())
                        .error(exp.getMessage())
                        .build());
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ExceptionResponse> handleException(DisabledException exp){
        return ResponseEntity
                .status(ACCOUNT_DISABLED.getHttpStatus())
                .body(ExceptionResponse.builder()
                        .businessErrorCode(ACCOUNT_DISABLED.getHttpStatus().value())
                        .businessExceptionDescription(ACCOUNT_DISABLED.getDescription())
                        .error(exp.getMessage())
                        .build());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleException(BadCredentialsException exp){
        return ResponseEntity
                .status(BAD_CREDENTIALS.getHttpStatus())
                .body(ExceptionResponse.builder()
                        .businessErrorCode(BAD_CREDENTIALS.getHttpStatus().value())
                        .businessExceptionDescription(BAD_CREDENTIALS.getDescription())
                        .error(exp.getMessage())
                        .build());
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleException(AlreadyExistsException exp){
        return ResponseEntity
                .status(ALREADY_EXISTS.getHttpStatus())
                .body(ExceptionResponse.builder()
                        .businessErrorCode(ALREADY_EXISTS.getHttpStatus().value())
                        .businessExceptionDescription(ALREADY_EXISTS.getDescription())
                        .error(exp.getMessage())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException exp){
        Set<String> errors = new HashSet<>();
        exp.getBindingResult().getFieldErrors()
                .forEach(error -> errors.add(error.getDefaultMessage()));
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(ExceptionResponse.builder()
                        .validationErrors(errors)
                        .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException(NotFoundException exp){
        return ResponseEntity
                .status(NOT_FOUND.getHttpStatus())
                .body(ExceptionResponse.builder()
                        .businessErrorCode(NOT_FOUND.getHttpStatus().value())
                        .businessExceptionDescription(NOT_FOUND.getDescription())
                        .error(exp.getMessage())
                        .build());
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleException(UnAuthorizedException exp){
        return ResponseEntity
                .status(UNAUTHORIZED.getHttpStatus())
                .body(ExceptionResponse.builder()
                        .businessErrorCode(UNAUTHORIZED.getHttpStatus().value())
                        .businessExceptionDescription(UNAUTHORIZED.getDescription())
                        .error(exp.getMessage())
                        .build());
    }

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<ExceptionResponse> handleException(MessagingException exp){
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ExceptionResponse.builder()
                        .error(exp.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception exp){
        exp.printStackTrace();
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(ExceptionResponse.builder()
                        .businessExceptionDescription("Internal error, please contact support.")
                        .error(exp.getMessage())
                        .build());
    }
}
