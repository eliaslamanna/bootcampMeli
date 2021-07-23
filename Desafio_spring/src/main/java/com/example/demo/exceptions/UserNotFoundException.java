package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends SocialMeliException {
    public UserNotFoundException(Integer userId) {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("User not found", "The user with id: " + userId + " cant be found."));
    }
}
