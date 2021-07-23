package com.example.demo.comparators;

import com.example.demo.dtos.FollowersDTO;
import com.example.demo.dtos.UserDTO;
import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;

public class UserNameOrder implements Comparator<UserDTO> {
    @Override
    public int compare(UserDTO o1, UserDTO o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
