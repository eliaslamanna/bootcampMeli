package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class LargestRoomNotFoundException extends TuCasitaException {
    public LargestRoomNotFoundException() {
        super(new ErrorDTO("Largest room not found", "The largest room of the house couldn't be found"), HttpStatus.BAD_REQUEST);
    }
}
