package com.example.demo.services;

import com.example.demo.comparators.UserNameOrder;
import com.example.demo.dtos.FollowedDTO;
import com.example.demo.dtos.FollowerCountDTO;
import com.example.demo.dtos.FollowersDTO;
import com.example.demo.dtos.UserDTO;
import com.example.demo.exceptions.*;
import com.example.demo.models.Seller;
import com.example.demo.models.User;
import com.example.demo.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UsersService implements IUsersService {

    @Autowired
    ISocialMeliRepository socialMeliRepository;

    @Override
    public Void followUser(Integer userId, Integer userIdToFollow) throws UserNotFoundException, SellerNotFoundException, IOException, UserIsAlreadyAFollowerException, SellerAlreadyFollowedException, SameUserException {
        if(userId.equals(userIdToFollow)) {
            throw new SameUserException();
        }
        User user = socialMeliRepository.findUser(userId);
        Seller seller = socialMeliRepository.findSeller(userIdToFollow);
        if(user.getFollowList().contains(seller)) {
            throw new SellerAlreadyFollowedException(userIdToFollow);
        }
        user.getFollowList().add(seller);
        if(seller.getFollowers().contains(new UserDTO(user.getUserId(), user.getName()))) {
            throw new UserIsAlreadyAFollowerException(userId);
        }
        seller.getFollowers().add(new UserDTO(user.getUserId(),user.getName()));
        return null;
    }

    @Override
    public FollowerCountDTO followersCount(Integer userId) throws SellerNotFoundException {
        Seller seller = socialMeliRepository.findSeller(userId);
        return new FollowerCountDTO(userId,seller.getName(), seller.getFollowers().size());
    }

    @Override
    public FollowersDTO getFollowers(Integer userId, String order) throws SellerNotFoundException {
        Seller seller = socialMeliRepository.findSeller(userId);
        FollowersDTO followers = new FollowersDTO(userId, seller.getName(), this.getFollowersDTO(seller));
        if(order.equals("name_asc")) {
            Collections.sort(followers.getFollowers(), new UserNameOrder());
        }
        else if(order.equals("name_desc")) {
            Collections.sort(followers.getFollowers(), new UserNameOrder().reversed());
        }
        return followers;
    }

    @Override
    public FollowedDTO getFollowed(Integer userId, String order) throws UserNotFoundException {
        User user = socialMeliRepository.findUser(userId);
        FollowedDTO followed = new FollowedDTO(userId, user.getName(), this.getFollowedDTO(user));
        if(order.equals("name_asc")) {
            Collections.sort(followed.getFollowed(), new UserNameOrder());
        }
        else if(order.equals("name_desc")) {
            Collections.sort(followed.getFollowed(), new UserNameOrder().reversed());
        }
        return followed;
    }

    @Override
    public void unfollow(Integer userId, Integer userIdToUnfollow) throws NotFollowedException, NotInFollowersListException, SellerNotFoundException, UserNotFoundException, IOException, SameUserException {
        if(userId.equals(userIdToUnfollow)) {
            throw new SameUserException();
        }
        User user = socialMeliRepository.findUser(userId);
        Seller seller =  socialMeliRepository.findSeller(userIdToUnfollow);
        if(!user.getFollowList().contains(seller)) {
            throw new NotFollowedException(userIdToUnfollow);
        }
        user.getFollowList().remove(seller);
        if(!seller.getFollowers().contains(new UserDTO(user.getUserId(), user.getName()))) {
            throw new NotInFollowersListException(userId);
        }
        seller.getFollowers().remove(new UserDTO(user.getUserId(), user.getName()));
    }

    private List<UserDTO> getFollowersDTO(Seller seller) {
        List<UserDTO> users = new ArrayList<>();
        seller.getFollowers().stream().forEach(user -> users.add(user) );
        return users;
    }

    private List<UserDTO> getFollowedDTO(User user) {
        List<UserDTO> users = new ArrayList<>();
        user.getFollowList().stream().forEach(u -> users.add(new UserDTO(u.getUserId(), u.getName())));
        return users;
    }

}
