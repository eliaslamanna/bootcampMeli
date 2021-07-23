package com.example.demo.repository;

import com.example.demo.entity.AgendaDAO;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgendaRepository extends CrudRepository<AgendaDAO, Integer> {

}
