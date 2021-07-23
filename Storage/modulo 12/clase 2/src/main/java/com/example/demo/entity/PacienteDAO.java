package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "PACIENTE")
public class PacienteDAO {
    @Id
    @GeneratedValue
    private Long dni;

    private String name;

    @OneToOne(mappedBy = "fecha_turno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TurnoDAO turno;
}
