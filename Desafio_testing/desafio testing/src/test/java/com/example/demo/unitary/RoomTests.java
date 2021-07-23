package com.example.demo.unitary;

import com.example.demo.models.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class RoomTests {

    @Test
    void roomNameCantBeEmptyTest() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room blankNameRoom = new Room("", 10D,30D);

        Set<ConstraintViolation<Room>> violations = validator.validate(blankNameRoom);

        String errorMessage = "";

        for(ConstraintViolation<Room> err : violations) {
            if(err.getMessage().equals("El nombre del ambiente no puede estar vacío.")) {
                errorMessage = err.getMessage();
            }
        }
        //Assert
        Assertions.assertEquals("El nombre del ambiente no puede estar vacío.",errorMessage);
    }

    @Test
    void roomNameStartsWithLowerCaseFailsTest() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room lowerCaseNameRoom = new Room("cocina", 10D,30D);

        Set<ConstraintViolation<Room>> violations = validator.validate(lowerCaseNameRoom);

        String errorMessage = "";

        for(ConstraintViolation<Room> err : violations) {
            errorMessage = err.getMessage();
        }
        //Assert
        Assertions.assertEquals("El nombre del ambiente debe comenzar con mayúscula.",errorMessage);
    }

    @Test
    void roomNameLengthCantBeMoraThan30Test() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room wrongNameLengthRoom = new Room("CocinaCocinaCocinaCocinaCocinaCocinaCocinaCocinaCocinaCocinaCocinaCocinaCocinaCocinaCocina", 10D,30D);

        Set<ConstraintViolation<Room>> violations = validator.validate(wrongNameLengthRoom);

        String errorMessage = "";

        for(ConstraintViolation<Room> err : violations) {
            errorMessage = err.getMessage();
        }
        //Assert
        Assertions.assertEquals("La longitud del ambiente no puede superar los 30 caracteres.",errorMessage);
    }

    @Test
    void roomWidthCantBeEmptyTest() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room emptyWidthRoom = new Room("Cocina", null,30D);

        Set<ConstraintViolation<Room>> violations = validator.validate(emptyWidthRoom);

        String errorMessage = "";

        for(ConstraintViolation<Room> err : violations) {
            errorMessage = err.getMessage();
        }
        //Assert
        Assertions.assertEquals("El ancho del ambiente no puede estar vacío.",errorMessage);
    }

    @Test
    void roomLengthCantBeEmptyTest() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room emptyLengthRoom = new Room("Cocina", 10D,null);

        Set<ConstraintViolation<Room>> violations = validator.validate(emptyLengthRoom);

        String errorMessage = "";

        for(ConstraintViolation<Room> err : violations) {
            errorMessage = err.getMessage();
        }
        //Assert
        Assertions.assertEquals("El largo del ambiente no puede estar vacío.",errorMessage);
    }

    @Test
    void roomWidthCantBeMoraThan25Test() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room wrongWidthRoom = new Room("Cocina", 30D,10D);

        Set<ConstraintViolation<Room>> violations = validator.validate(wrongWidthRoom);

        String errorMessage = "";

        for(ConstraintViolation<Room> err : violations) {
            errorMessage = err.getMessage();
        }
        //Assert
        Assertions.assertEquals("El máximo ancho permitido por propiedad es de 25 mts",errorMessage);
    }

    @Test
    void roomLengthCantBeMoraThan33Test() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Room wrongLengthRoom = new Room("Cocina", 10D,34D);

        Set<ConstraintViolation<Room>> violations = validator.validate(wrongLengthRoom);

        String errorMessage = "";

        for(ConstraintViolation<Room> err : violations) {
            errorMessage = err.getMessage();
        }
        //Assert
        Assertions.assertEquals("El máximo largo permitido por propiedad es de 33 mts",errorMessage);
    }
}
