package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class UserIsAlreadyAFollowerException extends SocialMeliException {
    public UserIsAlreadyAFollowerException(Integer userId) {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("User is already a follower", "The user with id: " + userId + " is already a follower"));
    }
}
