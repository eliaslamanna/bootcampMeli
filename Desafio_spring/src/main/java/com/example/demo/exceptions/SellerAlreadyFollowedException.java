package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class SellerAlreadyFollowedException extends SocialMeliException {
    public SellerAlreadyFollowedException(Integer userId) {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Seller already followed", "The seller with id: " + userId + " is already followed"));
    }
}
