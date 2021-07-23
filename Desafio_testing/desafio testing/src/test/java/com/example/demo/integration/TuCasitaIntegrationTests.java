package com.example.demo.integration;

import com.example.demo.dtos.SquareMetresDTO;
import com.example.demo.dtos.SquareMetresPerRoomResponseDTO;
import com.example.demo.models.District;
import com.example.demo.models.House;
import com.example.demo.models.Room;
import com.example.demo.repository.TuCasitaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TuCasitaIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TuCasitaRepository repository;

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
    public void getSquareMetresCorrectly() throws Exception {
        //arrange
        SquareMetresDTO expected = new SquareMetresDTO("MiCasita", 500);
        Mockito.when(repository.getDistricts()).thenReturn(new ArrayList<>() {{add(new District("Saavedra", 200));}});
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(house);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/squareMetres").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expected.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value").value(expected.getValue()))
                .andReturn();
    }

    @Test
    public void getPriceCorrectly() throws Exception {
        //arrange
        SquareMetresDTO expected = new SquareMetresDTO("MiCasita", 100000);
        Mockito.when(repository.getDistricts()).thenReturn(new ArrayList<>() {{add(new District("Saavedra", 200));}});
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(house);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/price").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expected.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value").value(expected.getValue()))
                .andReturn();
    }

    @Test
    public void getLargestRoomCorrectly() throws Exception {
        //arrange
        Room expected = new Room("cocina", 10D,30D);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(house);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/largestRoom").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roomName").value(expected.getRoomName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roomWidth").value(expected.getRoomWidth()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.roomLength").value(expected.getRoomLength()))
                .andReturn();
    }

    @Test
    public void getSquareMetresPerRoomCorrectly() throws Exception {
        //arrange
        ArrayList<SquareMetresDTO> rooms = new ArrayList<>();
        rooms.add(new SquareMetresDTO("cocina", 300));
        rooms.add(new SquareMetresDTO("cuarto", 100));
        rooms.add(new SquareMetresDTO("comedor", 100));
        SquareMetresPerRoomResponseDTO expected = new SquareMetresPerRoomResponseDTO(rooms);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(house);

        //act
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/squareMetresPerRoom").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();
        SquareMetresPerRoomResponseDTO studentDTO1 = mapper.readValue( mvcResult.getResponse().getContentAsString(), SquareMetresPerRoomResponseDTO.class);
        Assertions.assertEquals(expected,studentDTO1);
    }

}
