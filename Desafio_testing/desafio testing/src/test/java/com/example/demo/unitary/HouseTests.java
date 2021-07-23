package com.example.demo.unitary;

import com.example.demo.models.House;
import com.example.demo.models.Room;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Set;

public class HouseTests {

    @Test
    void houseNameStarsWithLowerCaseFailsTest(){
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House lowerCaseNameHouse = new House("miCasita", "Saavedra",200D, new ArrayList<>(){{
            add(new Room("cocina", 10D,30D));
            add(new Room("cuarto", 10D, 10D));
            add(new Room("comedor", 5D, 20D));
        }});
        Set<ConstraintViolation<House>> violations = validator.validate(lowerCaseNameHouse);

        String errorMessage = "";

        //Assert
        for(ConstraintViolation<House> err : violations) {
            errorMessage = err.getMessage();
        }
        Assertions.assertEquals(errorMessage,"El nombre de la propiedad debe comenzar con mayúscula.");
    }

    @Test
    void houseNameLengthCantBeMoreThan30Test(){
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House wrongNameLengthHouse = new House("MiCasitamiCasitamiCasitamiCasitamiCasitamiCasitamiCasitamiCasitamiCasitamiCasitamiCasita", "Saavedra",200D, new ArrayList<>(){{
            add(new Room("cocina", 10D,30D));
            add(new Room("cuarto", 10D, 10D));
            add(new Room("comedor", 5D, 20D));
        }});
        Set<ConstraintViolation<House>> violations = validator.validate(wrongNameLengthHouse);

        String errorMessage = "";

        //Assert
        for(ConstraintViolation<House> err : violations) {
            errorMessage = err.getMessage();
            System.out.println(err.getMessage());
        }
        Assertions.assertEquals(errorMessage,"La longitud del nombre no puede superar los 30 caracteres.");
    }

    @Test
    void houseNameCantBeBlankTest(){
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House blankNameHouse = new House("", "Saavedra",200D, new ArrayList<>(){{
            add(new Room("cocina", 10D,30D));
            add(new Room("cuarto", 10D, 10D));
            add(new Room("comedor", 5D, 20D));
        }});
        Set<ConstraintViolation<House>> violations = validator.validate(blankNameHouse);

        String errorMessage = "";

        for(ConstraintViolation<House> err : violations) {
            if(err.getMessage().equals("El nombre de la propiedad no puede estar vacío.")) {
                errorMessage = err.getMessage();
            }
        }
        //Assert
        Assertions.assertEquals("El nombre de la propiedad no puede estar vacío.",errorMessage);
    }

    @Test
    void houseDistrictNameCantBeBlankTest() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House blankDistrictNameHouse = new House("Micasa", "",200D, new ArrayList<>(){{
            add(new Room("cocina", 10D,30D));
            add(new Room("cuarto", 10D, 10D));
            add(new Room("comedor", 5D, 20D));
        }});
        Set<ConstraintViolation<House>> violations = validator.validate(blankDistrictNameHouse);

        String errorMessage = "";

        for(ConstraintViolation<House> err : violations) {
            if(err.getMessage().equals("El barrio no puede estar vacío.")) {
                errorMessage = err.getMessage();
            }
        }
        //Assert
        Assertions.assertEquals("El barrio no puede estar vacío.",errorMessage);
    }

    @Test
    void houseDistrictNameLengthCantBeMoreThan45Test() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House wrongDistrictNameLengthHouse = new House("Micasa", "SaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedraSaavedra",200D, new ArrayList<>(){{
            add(new Room("cocina", 10D,30D));
            add(new Room("cuarto", 10D, 10D));
            add(new Room("comedor", 5D, 20D));
        }});
        Set<ConstraintViolation<House>> violations = validator.validate(wrongDistrictNameLengthHouse);

        String errorMessage = "";

        for(ConstraintViolation<House> err : violations) {
            errorMessage = err.getMessage();
        }
        //Assert
        Assertions.assertEquals("La longitud del barrio no puede superar los 45 caracteres.",errorMessage);
    }

    @Test
    void houseDistrictPriceCantBeEmptyTest() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House invalidPriceHouse = new House("Micasa", "Saavedra", null, new ArrayList<>(){{
            add(new Room("cocina", 10D,30D));
            add(new Room("cuarto", 10D, 10D));
            add(new Room("comedor", 5D, 20D));
        }});

        Set<ConstraintViolation<House>> violations = validator.validate(invalidPriceHouse);

        String errorMessage = "";

        for(ConstraintViolation<House> err : violations) {
            if(err.getMessage().equals("El precio del barrio no puede estar vacío.")) {
                errorMessage = err.getMessage();
            }
        }
        //Assert
        Assertions.assertEquals("El precio del barrio no puede estar vacío.",errorMessage);
    }

    @Test
    void houseDistrictPriceCantBeMoreThan4000Test() {
        //Arrange
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        House invalidPriceHouse = new House("Micasa", "Saavedra", 4001D, new ArrayList<>(){{
            add(new Room("cocina", 10D,30D));
            add(new Room("cuarto", 10D, 10D));
            add(new Room("comedor", 5D, 20D));
        }});

        Set<ConstraintViolation<House>> violations = validator.validate(invalidPriceHouse);

        String errorMessage = "";

        for(ConstraintViolation<House> err : violations) {
            errorMessage = err.getMessage();
        }
        //Assert
        Assertions.assertEquals("El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.",errorMessage);
    }
}
