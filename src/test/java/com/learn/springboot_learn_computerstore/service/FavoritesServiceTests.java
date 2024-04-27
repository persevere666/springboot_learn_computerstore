package com.learn.springboot_learn_computerstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FavoritesServiceTests {

    @Autowired
    IFavoritesService favoritesService;

    @Test
    public void addFavorites(){
        int fid = favoritesService.addFavorites(8, 10000001);
        System.out.println("addFavorites="+fid);
    }
    
}
