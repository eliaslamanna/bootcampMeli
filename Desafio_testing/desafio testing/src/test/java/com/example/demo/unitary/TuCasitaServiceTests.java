package com.example.demo.unitary;

import com.example.demo.dtos.SquareMetresDTO;
import com.example.demo.dtos.SquareMetresPerRoomResponseDTO;
import com.example.demo.exceptions.DistrictNotMatchException;
import com.example.demo.exceptions.LargestRoomNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.House;
import com.example.demo.models.Room;
import com.example.demo.repository.TuCasitaRepository;
import com.example.demo.services.TuCasitaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class TuCasitaServiceTests {

    @Mock
    TuCasitaRepository repository;

    @InjectMocks
    TuCasitaService service;

    static House house;

    @BeforeAll
    static void initialize() {
            house = new House("MiCasita", "Saavedra",200D, new ArrayList<>(){{
                add(new Room("cocina", 10D,30D));
                add(new Room("cuarto", 10D, 10D));
                add(new Room("comedor", 5D, 20D));
            }});
    }

    @Test
    void getSquareMetresCorrectlyTest() {
        //Arrange
        //Act
        //Assert
        Assertions.assertEquals(500, service.getSquareMetres(house).getValue());
    }

    @Test
    void incorrectDistrictExceptionTest() {
        //Arrange
        House incorrectHouse = new House("MiCasita", "Saavedra",100D, new ArrayList<>());
        Mockito.when(repository.getDistricts()).thenReturn(new ArrayList<>(){{add(new District("Saavedra",200));}});
        //Act
        //Assert
        Assertions.assertThrows(DistrictNotMatchException.class,() -> service.calculatePrice(incorrectHouse));
        Mockito.verify(repository, Mockito.atLeastOnce()).getDistricts();
    }

    @Test
    void findCorrectDistrictTest() throws DistrictNotMatchException {
        //Arrange
        House newHouse = new House("MiCasita", "Saavedra",200D, new ArrayList<>());
        Mockito.when(repository.getDistricts()).thenReturn(new ArrayList<>(){{add(new District("Saavedra",200));}});
        //Act
        //Assert
        Assertions.assertEquals(new District("Saavedra", 200),service.findDistrict(newHouse));
        Mockito.verify(repository, Mockito.atLeastOnce()).getDistricts();
    }

    @Test
    void getCorrectHousePriceTest() throws DistrictNotMatchException {
        //Arrange
        Mockito.when(repository.getDistricts()).thenReturn(new ArrayList<>(){{add(new District("Saavedra",200));}});
        //Act
        //Assert
        Assertions.assertEquals(100000,service.calculatePrice(house).getValue());
        Mockito.verify(repository, Mockito.atLeastOnce()).getDistricts();
    }

    @Test
    void getLargestRoomTest() throws LargestRoomNotFoundException {
        //Arrange
        Room expectedRoom = new Room("cocina", 10D, 30D);
        //Act
        //Assert
        Assertions.assertEquals(expectedRoom, service.getLargestRoom(house));
    }

    @Test
    void getSquareMetresPerRoomTest() {
        //Arrange
        SquareMetresPerRoomResponseDTO rooms = new SquareMetresPerRoomResponseDTO(new ArrayList<>() {{
            add(new SquareMetresDTO("cocina", 300));
            add(new SquareMetresDTO("cuarto", 100));
            add(new SquareMetresDTO("comedor", 100));
        }});
        //Act
        //Assert
        Assertions.assertEquals(rooms, service.getSquareMetresPerRoom(house));
    }

}
