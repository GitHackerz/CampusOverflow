package com.example.campusoverflow.exceptions;

public class UnAuthorizedException extends RuntimeException{

        public UnAuthorizedException(String message) {
            super(message);
        }
}
