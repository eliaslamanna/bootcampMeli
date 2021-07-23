package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import com.example.demo.exceptions.TuCasitaException;
import org.springframework.http.HttpStatus;

public class CantOpenFileException extends TuCasitaException {
    public CantOpenFileException() {
        super(new ErrorDTO("Cant open file", "The file couldn't be opened"), HttpStatus.BAD_REQUEST);
    }
}
