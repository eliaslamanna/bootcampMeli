package com.example.demo.repository;

import com.example.demo.entity.AgendaDAO;
import com.example.demo.entity.PacienteDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends CrudRepository<PacienteDAO, Long> {
}
