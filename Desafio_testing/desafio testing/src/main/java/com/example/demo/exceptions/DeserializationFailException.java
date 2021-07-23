package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class DeserializationFailException extends TuCasitaException {
    public DeserializationFailException() {
        super(new ErrorDTO("Cant deserialize Json", "The Json couldn't be deserialized"), HttpStatus.BAD_REQUEST);
    }
}
