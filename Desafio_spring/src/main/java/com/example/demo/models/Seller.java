package com.example.demo.models;

import com.example.demo.dtos.PostDTO;
import com.example.demo.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller extends User {
    private List<PostDTO> posts = new ArrayList<>();
    private List<UserDTO> followers = new ArrayList<>();
}
