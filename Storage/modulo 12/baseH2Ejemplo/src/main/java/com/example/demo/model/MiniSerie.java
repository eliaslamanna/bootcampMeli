package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class MiniSerie {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Double rating;

    private Integer awards;
}
