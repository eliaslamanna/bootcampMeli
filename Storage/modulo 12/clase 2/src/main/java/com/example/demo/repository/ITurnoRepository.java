package com.example.demo.repository;

import com.example.demo.entity.AgendaDAO;
import com.example.demo.entity.TurnoDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends CrudRepository<TurnoDAO, Integer> {
}
