package com.example.demo.controllers;

import com.example.demo.dtos.FollowedDTO;
import com.example.demo.dtos.FollowerCountDTO;
import com.example.demo.dtos.FollowersDTO;
import com.example.demo.exceptions.*;
import com.example.demo.services.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    IUsersService usersService;

    //the user with userId adds the seller with userIdToFollow to their follow list
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<Void> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) throws UserNotFoundException, SellerNotFoundException, IOException, UserIsAlreadyAFollowerException, SellerAlreadyFollowedException, SameUserException {
        return new ResponseEntity<>(usersService.followUser(userId, userIdToFollow),HttpStatus.OK);
    }

    //Get the amount of users that follow a seller with the userId
    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<FollowerCountDTO> followersCount(@PathVariable Integer userId) throws SellerNotFoundException {
        return new ResponseEntity<>(usersService.followersCount(userId), HttpStatus.OK);
    }

    //Get a list of users that follow a seller with the userId
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDTO> getFollowers(@PathVariable Integer userId, @RequestParam(name="order", required = false, defaultValue = "") String order) throws SellerNotFoundException {
        return new ResponseEntity<>(usersService.getFollowers(userId, order),HttpStatus.OK);
    }

    //Get a list of all the sellers that a user with the userId follows
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> getFollowed(@PathVariable Integer userId, @RequestParam(name="order", required = false, defaultValue = "") String order) throws UserNotFoundException {
        return new ResponseEntity<>(usersService.getFollowed(userId, order),HttpStatus.OK);
    }

    //A user with the userId removes a seller with the userIdToUnfollow from their follow list
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public void unfollow(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) throws NotFollowedException, NotInFollowersListException, SellerNotFoundException, UserNotFoundException, IOException, SameUserException {
        usersService.unfollow(userId, userIdToUnfollow);
    }
}
