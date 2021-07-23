package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class FailToLoadSellersException extends SocialMeliException {
    public FailToLoadSellersException() {
        super(HttpStatus.BAD_REQUEST, new ErrorDTO("Fail to load sellers", "The sellers couldn't be loaded"));
    }
}
