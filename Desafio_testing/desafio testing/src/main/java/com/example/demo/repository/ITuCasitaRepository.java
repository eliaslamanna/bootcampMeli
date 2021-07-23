package com.example.demo.repository;

import com.example.demo.exceptions.CantOpenFileException;
import com.example.demo.exceptions.DeserializationFailException;
import com.example.demo.models.District;

import java.util.List;

public interface ITuCasitaRepository {
    public List<District> findAll() throws CantOpenFileException, DeserializationFailException;
    public List<District> getDistricts();
}
