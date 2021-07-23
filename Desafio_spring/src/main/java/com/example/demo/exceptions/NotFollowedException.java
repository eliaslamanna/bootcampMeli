package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class NotFollowedException extends SocialMeliException {
    public NotFollowedException(Integer userId) {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Not followed", "User with id: " + userId + " is not followed"));
    }
}
