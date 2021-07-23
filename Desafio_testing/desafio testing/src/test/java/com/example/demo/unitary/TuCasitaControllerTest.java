package com.example.demo.unitary;

import com.example.demo.controllers.TuCasitaController;
import com.example.demo.dtos.SquareMetresDTO;
import com.example.demo.dtos.SquareMetresPerRoomResponseDTO;
import com.example.demo.exceptions.DistrictNotMatchException;
import com.example.demo.exceptions.LargestRoomNotFoundException;
import com.example.demo.models.House;
import com.example.demo.models.Room;
import com.example.demo.services.TuCasitaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class TuCasitaControllerTest {

    @Mock
    TuCasitaService service;

    @InjectMocks
    TuCasitaController controller;

    House house;

    @BeforeEach
    void initHouse(){
        house = new House("MiCasita", "Saavedra",200D, new ArrayList<>(){{
            add(new Room("cocina", 10D,30D));
            add(new Room("cuarto", 10D, 10D));
            add(new Room("comedor", 5D, 20D));
        }});
    }

    @Test
    void getSquareMetresTest() {
        //Arrange
        SquareMetresDTO squareMetres = new SquareMetresDTO("MiCasita",500);
        ResponseEntity<SquareMetresDTO> expected = new ResponseEntity<>(squareMetres, HttpStatus.OK);
        Mockito.when(service.getSquareMetres(house)).thenReturn(squareMetres);
        //Act
        ResponseEntity<SquareMetresDTO> response = controller.getSquareMetres(house);
        //Assert
        Mockito.verify(service, Mockito.atLeastOnce()).getSquareMetres(house);
        Assertions.assertEquals(expected,response);
    }

    @Test
    void getPriceTest() throws DistrictNotMatchException {
        //Arrange
        SquareMetresDTO squareMetres = new SquareMetresDTO("MiCasita",500);
        ResponseEntity<SquareMetresDTO> expected = new ResponseEntity<>(squareMetres, HttpStatus.OK);
        Mockito.when(service.calculatePrice(house)).thenReturn(squareMetres);
        //Act
        ResponseEntity<SquareMetresDTO> response = controller.getPrice(house);
        //Assert
        Mockito.verify(service, Mockito.atLeastOnce()).calculatePrice(house);
        Assertions.assertEquals(expected,response);
    }

    @Test
    void getLargestRoomTest() throws LargestRoomNotFoundException {
        //Arrange
        Room room = new Room("cocina", 10D,30D);
        ResponseEntity<Room> expected = new ResponseEntity<>(room, HttpStatus.OK);
        Mockito.when(service.getLargestRoom(house)).thenReturn(room);
        //Act
        ResponseEntity<Room> response = controller.getLargestRoom(house);
        //Assert
        Mockito.verify(service, Mockito.atLeastOnce()).getLargestRoom(house);
        Assertions.assertEquals(expected,response);
    }

    @Test
    void getSquareMetresPerRoomTest() {
        //Arrange
        ArrayList<SquareMetresDTO> rooms = new ArrayList<>();
        rooms.add(new SquareMetresDTO("cocina", 300));
        rooms.add(new SquareMetresDTO("cuarto", 100));
        rooms.add(new SquareMetresDTO("comedor", 100));
        SquareMetresPerRoomResponseDTO squareMetres = new SquareMetresPerRoomResponseDTO(rooms);
        ResponseEntity<SquareMetresPerRoomResponseDTO> expected = new ResponseEntity<>(squareMetres, HttpStatus.OK);
        Mockito.when(service.getSquareMetresPerRoom(house)).thenReturn(squareMetres);
        //Act
        ResponseEntity<SquareMetresPerRoomResponseDTO> response = controller.getSquareMetresPerRoom(house);
        //Assert
        Mockito.verify(service, Mockito.atLeastOnce()).getSquareMetresPerRoom(house);
        Assertions.assertEquals(expected,response);
    }
}
