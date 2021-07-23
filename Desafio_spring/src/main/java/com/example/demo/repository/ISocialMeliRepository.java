package com.example.demo.repository;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.*;
import com.example.demo.models.Seller;
import com.example.demo.models.User;

import java.io.IOException;

public interface ISocialMeliRepository {

    //Add a post to a seller
    public void createPost(PostDTO newPost) throws SellerNotFoundException, IOException, PostAlreadyExistsException;
    //Looks for a user with the userId in stored users
    public User findUser(Integer userId) throws UserNotFoundException;
    //Looks for a seller with the sellerId in stored sellers
    public Seller findSeller(Integer sellerId) throws SellerNotFoundException;

}
