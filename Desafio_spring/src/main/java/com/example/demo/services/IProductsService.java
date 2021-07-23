package com.example.demo.services;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.PostAlreadyExistsException;
import com.example.demo.exceptions.PromoPostExpectedException;
import com.example.demo.exceptions.SellerNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;

import java.io.IOException;

public interface IProductsService {
    //Creates a new post
    public void createPost(PostDTO newPost) throws SellerNotFoundException, IOException, PostAlreadyExistsException;
    //creates a new promo post (with promo and discount)
    public void createPromoPost(PromoPostDTO newPromoPost) throws PromoPostExpectedException, IOException, PostAlreadyExistsException, SellerNotFoundException;
    //Get the last 2 weeks posts from the sellers a user follows
    public FollowedPostsDTO followedPosts(Integer userId, String order) throws UserNotFoundException;
    //Get the amount of promo products a seller has posted
    public PromoProductCountDTO promoProductCount(Integer userId) throws SellerNotFoundException;
    //Get all the promo products a seller has posted
    public PromoPostListDTO getPromoProducts(Integer userId) throws SellerNotFoundException;
}
