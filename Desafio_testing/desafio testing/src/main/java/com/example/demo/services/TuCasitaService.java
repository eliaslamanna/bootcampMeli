package com.example.demo.services;

import com.example.demo.dtos.SquareMetresPerRoomResponseDTO;
import com.example.demo.exceptions.DistrictNotMatchException;
import com.example.demo.exceptions.LargestRoomNotFoundException;
import com.example.demo.models.District;
import com.example.demo.models.House;
import com.example.demo.models.Room;
import com.example.demo.dtos.SquareMetresDTO;
import com.example.demo.repository.ITuCasitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TuCasitaService implements ITuCasitaService {

    @Autowired
    ITuCasitaRepository tuCasitaRepository;

    public SquareMetresDTO getSquareMetres(House house) {
        double m2 = 0;
        for(Room room : house.getHabitaciones()) {
            m2 += room.getRoomWidth() * room.getRoomLength();
        }

        return new SquareMetresDTO(house.getPropName(), m2);
    }

    public SquareMetresDTO calculatePrice(House house) throws DistrictNotMatchException {
        District district = this.findDistrict(house);
        SquareMetresDTO response = getSquareMetres(house);
        return new SquareMetresDTO(response.getName(), response.getValue() * district.getPrice());
    }

    public Room getLargestRoom(House house) throws LargestRoomNotFoundException {
        Room masGrande = null;
        double m2Mayores = 0;
        for(Room room : house.getHabitaciones()) {
            if((room.getRoomWidth() * room.getRoomLength()) > m2Mayores) {
                m2Mayores = room.getRoomWidth() * room.getRoomLength();
                masGrande = room;
            }
        }
        if(masGrande == null) {
            throw new LargestRoomNotFoundException();
        }
        return masGrande;
    }

    public SquareMetresPerRoomResponseDTO getSquareMetresPerRoom(House house) {
        ArrayList<SquareMetresDTO> habitaciones = new ArrayList<>();
        for(Room room : house.getHabitaciones()) {
            SquareMetresDTO hab = new SquareMetresDTO(room.getRoomName(), room.getRoomWidth() * room.getRoomLength());
            habitaciones.add(hab);
        }
        return new SquareMetresPerRoomResponseDTO(habitaciones);
    }

    public District findDistrict(House house) throws DistrictNotMatchException {
        Optional<District> district = tuCasitaRepository.getDistricts().stream().filter(d ->
                d.getName().equals(house.getDistrictName()) && d.getPrice() == house.getDistrictPrice()
        ).findFirst();
        if(district.isEmpty()) {
            throw new DistrictNotMatchException(house.getDistrictName(), house.getDistrictPrice());
        }
        return district.get();
    }
}
