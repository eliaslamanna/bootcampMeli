package com.example.demo.dtos;

import com.example.demo.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"postId"})
public class PostDTO {
    private Integer userId;
    private Integer postId;
    private String date;
    private Product detail;
    private Integer category;
    private double price;

    public Boolean hasPromo() {
        return false;
    }
}
