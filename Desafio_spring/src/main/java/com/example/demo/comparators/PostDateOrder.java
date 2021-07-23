package com.example.demo.comparators;

import com.example.demo.dtos.PostDTO;

import java.util.Collections;
import java.util.Comparator;

public class PostDateOrder implements Comparator<PostDTO> {
    @Override
    public int compare(PostDTO o1, PostDTO o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
