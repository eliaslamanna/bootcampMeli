package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class SameUserException extends SocialMeliException {
    public SameUserException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Same user", "The user is the same"));
    }
}
