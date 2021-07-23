package com.example.demo.controllers;

import com.example.demo.dtos.*;
import com.example.demo.exceptions.PostAlreadyExistsException;
import com.example.demo.exceptions.PromoPostExpectedException;
import com.example.demo.exceptions.SellerNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.services.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    IProductsService productsService;

    //Creates new post assigning it to the user with the id in newPost
    @PostMapping("/newpost")
    public void newPost(@RequestBody PostDTO newPost) throws SellerNotFoundException, IOException, PostAlreadyExistsException {
        productsService.createPost(newPost);
    }

    //Get the list of post from a seller a user with the userId follows within 2 weeks and returns them in descending order
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<FollowedPostsDTO> follewedPosts(@PathVariable Integer userId, @RequestParam(name="order", required = false, defaultValue = "") String order) throws UserNotFoundException {
        return new ResponseEntity<>(productsService.followedPosts(userId, order),HttpStatus.OK);
    }

    //Creates a new promo post for the seller with the id in promoPost
    @PostMapping("/newpromopost")
    public void newPromoPost(@RequestBody PromoPostDTO promoPost) throws SellerNotFoundException, IOException, PostAlreadyExistsException, PromoPostExpectedException {
        productsService.createPromoPost(promoPost);
    }

    //Counts the amount of promo posts a seller with the userId has
    @GetMapping("/{userId}/countPromo/")
    public ResponseEntity<PromoProductCountDTO> promoProductCount(@PathVariable Integer userId) throws SellerNotFoundException {
        return new ResponseEntity<>(productsService.promoProductCount(userId),HttpStatus.OK);
    }

    //Returns the list of promo post a seller with the userId has
    @GetMapping("/{userId}/list/")
    public ResponseEntity<PromoPostListDTO> promoProductsList(@PathVariable Integer userId) throws SellerNotFoundException {
        return new ResponseEntity<>(productsService.getPromoProducts(userId),HttpStatus.OK);
    }

}
