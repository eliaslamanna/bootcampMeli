package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedPostsDTO {
    private Integer userId;
    private List<PostDTO> posts;

    public FollowedPostsDTO(Integer userId) {
        this.userId = userId;
    }
}
