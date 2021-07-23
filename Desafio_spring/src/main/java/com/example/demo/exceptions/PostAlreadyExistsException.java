package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class PostAlreadyExistsException extends SocialMeliException {
    public PostAlreadyExistsException(Integer postId) {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Post already exists", "The post with id: " + postId + " already exists"));
    }
}
