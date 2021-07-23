package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
public class House {

        @NotBlank(message = "El nombre de la propiedad no puede estar vacío.")
        @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la propiedad debe comenzar con mayúscula.")
        @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
        private String propName;

        @NotBlank(message = "El barrio no puede estar vacío.")
        @Size(max = 45, message = "La longitud del barrio no puede superar los 45 caracteres.")
        private String districtName;

        @NotNull(message = "El precio del barrio no puede estar vacío.")
        @Max(value = 4000, message = "El precio máximo permitido por metro cuadrado no puede superar los 4000 U$S.")
        private Double districtPrice;

        private List<Room> habitaciones;
}
