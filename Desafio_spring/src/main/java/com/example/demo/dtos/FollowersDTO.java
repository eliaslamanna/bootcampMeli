package com.example.demo.dtos;

import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersDTO {
    private Integer userId;
    private String name;
    private List<UserDTO> followers;
}
