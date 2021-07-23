package com.example.demo.services;

import com.example.demo.comparators.PostDateOrder;
import com.example.demo.dtos.*;
import com.example.demo.exceptions.PostAlreadyExistsException;
import com.example.demo.exceptions.PromoPostExpectedException;
import com.example.demo.exceptions.SellerNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.models.Seller;
import com.example.demo.models.User;
import com.example.demo.repository.ISocialMeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    ISocialMeliRepository socialMeliRepository;
    @Override
    public void createPost(PostDTO newPost) throws SellerNotFoundException, IOException, PostAlreadyExistsException {
        socialMeliRepository.createPost(newPost);
    }

    @Override
    public void createPromoPost(PromoPostDTO newPromoPost) throws PromoPostExpectedException, IOException, PostAlreadyExistsException, SellerNotFoundException {
        if(!newPromoPost.hasPromo()) {
            throw new PromoPostExpectedException();
        }
        socialMeliRepository.createPost(newPromoPost);
    }

    @Override
    public FollowedPostsDTO followedPosts(Integer userId, String order) throws UserNotFoundException {
        User user = socialMeliRepository.findUser(userId);
        FollowedPostsDTO posts = new FollowedPostsDTO(userId);
        //always return the last two weeks' posts in ascending order
        this.filterPosts(user, posts);
        if(order.equals("date_asc")) {
            Collections.sort(posts.getPosts(), new PostDateOrder());
        }
        return posts;
    }

    @Override
    public PromoProductCountDTO promoProductCount(Integer userId) throws SellerNotFoundException {
        Seller seller =  socialMeliRepository.findSeller(userId);
        return new PromoProductCountDTO(userId, seller.getName(), (int) seller.getPosts().stream().filter(post -> post.hasPromo()).count());
    }

    @Override
    public PromoPostListDTO getPromoProducts(Integer userId) throws SellerNotFoundException {
        Seller seller = socialMeliRepository.findSeller(userId);
        return new PromoPostListDTO(userId, seller.getName(), seller.getPosts().stream().filter(post -> post.hasPromo()).collect(Collectors.toList()));
    }

    private void filterPosts(User user, FollowedPostsDTO posts) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        user.getFollowList().stream().forEach(seller -> {
            Collections.sort(seller.getPosts(), new PostDateOrder().reversed());
            posts.setPosts(seller.getPosts().stream().filter(p -> {
                return ChronoUnit.WEEKS.between(LocalDate.parse(p.getDate()).withDayOfMonth(1),LocalDate.parse(LocalDateTime.now().format(formatter))) <= 2;
            }).collect(Collectors.toList()));
        });
    }
}
