package com.example.demo.services;

import com.example.demo.dtos.FollowedDTO;
import com.example.demo.dtos.FollowerCountDTO;
import com.example.demo.dtos.FollowersDTO;
import com.example.demo.dtos.PostDTO;
import com.example.demo.exceptions.*;

import java.io.IOException;

public interface IUsersService {
    //Add seller to follow list
    public Void followUser(Integer userId, Integer userIdToFollow) throws UserNotFoundException, SellerNotFoundException, IOException, UserIsAlreadyAFollowerException, SellerAlreadyFollowedException, SameUserException;
    //Returns the count o followers that follow a seller
    public FollowerCountDTO followersCount(Integer userId) throws SellerNotFoundException;
    //Get a list of followers of a certain seller
    public FollowersDTO getFollowers(Integer userId, String order) throws SellerNotFoundException;
    //Get the sellers that a certain user follows
    public FollowedDTO getFollowed(Integer userId, String order) throws UserNotFoundException;
    //Remove from user's follow list a certain seller and from that seller's followers list that user
    public void unfollow(Integer userId, Integer userIdToUnfollow) throws NotFollowedException, NotInFollowersListException, SellerNotFoundException, UserNotFoundException, IOException, SameUserException;
}
