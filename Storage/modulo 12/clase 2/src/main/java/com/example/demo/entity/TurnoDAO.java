package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "TURNO")
public class TurnoDAO {

    @Id
    @Column(name = "fecha_turno")
    private LocalDate fecha;

}
