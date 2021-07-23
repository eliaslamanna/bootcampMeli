package com.example.demo.controllers;

import com.example.demo.dtos.SquareMetresDTO;
import com.example.demo.dtos.SquareMetresPerRoomResponseDTO;
import com.example.demo.exceptions.DistrictNotMatchException;
import com.example.demo.exceptions.LargestRoomNotFoundException;
import com.example.demo.models.House;
import com.example.demo.models.Room;
import com.example.demo.services.ITuCasitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TuCasitaController {

    @Autowired
    ITuCasitaService tuCasitaService;

    @PostMapping("/squareMetres")
    public ResponseEntity<SquareMetresDTO> getSquareMetres(@RequestBody @Valid House house) {
        return new ResponseEntity<>(tuCasitaService.getSquareMetres(house), HttpStatus.OK);
    }

    @PostMapping("/price")
    public ResponseEntity<SquareMetresDTO> getPrice(@RequestBody House house) throws DistrictNotMatchException {
        return new ResponseEntity<>(tuCasitaService.calculatePrice(house), HttpStatus.OK);
    }

    @PostMapping("/largestRoom")
    public ResponseEntity<Room> getLargestRoom(@RequestBody House house) throws LargestRoomNotFoundException {
        return new ResponseEntity<>(tuCasitaService.getLargestRoom(house), HttpStatus.OK);
    }

    @PostMapping("/squareMetresPerRoom")
    public ResponseEntity<SquareMetresPerRoomResponseDTO> getSquareMetresPerRoom(@RequestBody House house) {
        return new ResponseEntity<>(tuCasitaService.getSquareMetresPerRoom(house), HttpStatus.OK);
    }

}
