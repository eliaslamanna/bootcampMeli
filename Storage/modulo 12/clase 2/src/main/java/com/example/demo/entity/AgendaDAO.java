package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "AGENDA")
public class AgendaDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Integer id;

    @Column(name = "turno_fecha")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fecha_turno")
    private List<TurnoDAO> turno;

}
