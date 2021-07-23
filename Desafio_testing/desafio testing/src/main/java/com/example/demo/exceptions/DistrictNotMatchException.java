package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;

public class DistrictNotMatchException extends TuCasitaException {
    public DistrictNotMatchException(String name, Double price) {
        super(new ErrorDTO("Can't find District", "The district: " + name + " with the price: " + price + " couldn't be found"), HttpStatus.BAD_REQUEST);
    }
}
