package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialMeliException extends Exception{
    private HttpStatus httpStatus;
    private ErrorDTO error;
}

