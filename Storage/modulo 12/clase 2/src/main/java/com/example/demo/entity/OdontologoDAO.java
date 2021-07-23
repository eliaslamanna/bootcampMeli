package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ODONTOLOGO")
public class OdontologoDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dni;

    private String name;

    @Column(name = "agenda_id")
    @OneToOne(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AgendaDAO agenda;
}
