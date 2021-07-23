package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class SellerNotFoundException extends SocialMeliException {
    public SellerNotFoundException(Integer sellerId) {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Seller not found", "The seller with id: " + sellerId + " cant be found"));
    }
}
