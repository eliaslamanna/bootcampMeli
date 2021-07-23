package com.example.demo.services;

import com.example.demo.dtos.SquareMetresDTO;
import com.example.demo.dtos.SquareMetresPerRoomResponseDTO;
import com.example.demo.exceptions.DistrictNotMatchException;
import com.example.demo.exceptions.LargestRoomNotFoundException;
import com.example.demo.models.House;
import com.example.demo.models.Room;
import org.springframework.stereotype.Service;

@Service
public interface ITuCasitaService {
    public SquareMetresDTO getSquareMetres(House house);

    public SquareMetresDTO calculatePrice(House house) throws DistrictNotMatchException;

    public Room getLargestRoom(House house) throws LargestRoomNotFoundException;

    public SquareMetresPerRoomResponseDTO getSquareMetresPerRoom(House house);
}
