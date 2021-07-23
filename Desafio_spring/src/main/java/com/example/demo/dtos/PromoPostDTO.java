package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO extends PostDTO{
    private Boolean hasPromo = true;
    private double discount;

    @Override
    public Boolean hasPromo() {
        return this.hasPromo;
    }
}
