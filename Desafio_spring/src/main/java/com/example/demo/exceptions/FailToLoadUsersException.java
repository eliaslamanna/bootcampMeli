package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class FailToLoadUsersException extends SocialMeliException {
    public FailToLoadUsersException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Fail to load users", "The users couldn't be loaded"));
    }
}
