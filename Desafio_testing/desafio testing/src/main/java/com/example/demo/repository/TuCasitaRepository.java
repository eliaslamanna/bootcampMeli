package com.example.demo.repository;

import com.example.demo.exceptions.CantOpenFileException;
import com.example.demo.exceptions.DeserializationFailException;
import com.example.demo.models.District;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Repository
public class TuCasitaRepository implements ITuCasitaRepository {

    private List<District> districts;

    public TuCasitaRepository() throws DeserializationFailException, CantOpenFileException {
        this.districts = this.findAll();
    }

    @Override
    public List<District> findAll() throws CantOpenFileException, DeserializationFailException {
        ArrayList<District> loadedData;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:districts.json");
            loadedData = objectMapper.readValue(file, new TypeReference<>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new CantOpenFileException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new DeserializationFailException();
        }

        return loadedData;
    }

    public List<District> getDistricts() {
        return this.districts;
    }
}
