package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoProductCountDTO {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
