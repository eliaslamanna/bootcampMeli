package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SquareMetresPerRoomResponseDTO {
    private ArrayList<SquareMetresDTO> metresPerRoom;
}
