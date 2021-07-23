package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class NotInFollowersListException extends SocialMeliException {
    public NotInFollowersListException(Integer userId) {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Cant unfollow", "The user with id: " + userId + " cant be unfollowed because is not in followers list"));
    }
}
