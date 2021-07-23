package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class PromoPostExpectedException extends SocialMeliException {
    public PromoPostExpectedException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Promo Post Expected", "A promo post was expected but a normal post was given"));
    }
}
