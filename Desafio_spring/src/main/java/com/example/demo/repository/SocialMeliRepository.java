package com.example.demo.repository;

import com.example.demo.comparators.PostDateOrder;
import com.example.demo.comparators.UserNameOrder;
import com.example.demo.dtos.*;
import com.example.demo.exceptions.*;
import com.example.demo.models.Seller;
import com.example.demo.models.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class SocialMeliRepository implements ISocialMeliRepository {

    private List<User> users;
    private List<Seller> sellers;

    @Override
    public void createPost(PostDTO newPost) throws SellerNotFoundException, PostAlreadyExistsException {
        Seller seller = this.findSeller(newPost.getUserId());
        if(seller.getPosts().contains(newPost)) {
            throw new PostAlreadyExistsException(newPost.getPostId());
        }
        seller.getPosts().add(newPost);
    }

    public SocialMeliRepository() throws FailToLoadUsersException, FailToLoadSellersException {
        this.users = this.loadUsers();
        this.sellers = this.loadSellers();
    }

    @Override
    public User findUser(Integer userId) throws UserNotFoundException {
        User user = null;
        Optional<User> userAux = this.users.stream().filter(u -> u.getUserId().equals(userId)).findFirst();
        if(userAux.isEmpty()) {
            Optional<Seller> sellerAux = this.sellers.stream().filter(s -> s.getUserId().equals(userId)).findFirst();
            if(!sellerAux.isEmpty()) {
                user = sellerAux.get();
            }
        } else {
            user = userAux.get();
        }
        if(user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    @Override
    public Seller findSeller(Integer sellerId) throws SellerNotFoundException {
        Seller seller = null;
        Optional<Seller> sellerAux = this.sellers.stream().filter(s -> s.getUserId().equals(sellerId)).findFirst();
        if(!sellerAux.isEmpty()) {
            seller = sellerAux.get();
        }
        if(seller == null) {
            throw new SellerNotFoundException(sellerId);
        }
        return seller;
    }

    private List<User> loadUsers() throws FailToLoadUsersException {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> users = null;
        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FailToLoadUsersException();
        }
        return users;
    }

    private List<Seller> loadSellers() throws FailToLoadSellersException {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:sellers.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Seller>> typeRef = new TypeReference<>() {
        };
        List<Seller> sellers = null;
        try {
            sellers = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FailToLoadSellersException();
        }
        return sellers;
    }

}
