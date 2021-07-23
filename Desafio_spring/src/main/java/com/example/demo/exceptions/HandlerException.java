package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
    
    @ExceptionHandler(SocialMeliException.class)
    public ResponseEntity<ErrorDTO> notFollowedException(SocialMeliException e){
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

}
