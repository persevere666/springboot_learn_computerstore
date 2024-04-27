package com.learn.springboot_learn_computerstore.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.Favorites;

@SpringBootTest
public class FavoritesMapperTests {

    @Autowired
    FavoritesMapper favoritesMapper;

    @Test
    public void queryFavoritesByUidAndStatus(){
        List<Favorites> list = favoritesMapper.queryFavoritesByUidAndStatus(12, 0);
        System.out.println(list);
    }
    @Test
    public void addFavorites(){
        Favorites favorites = new Favorites();
        favorites.setUid(24);
        favorites.setPid(100000391);
        favorites.setImage("/images/portal/18(DELL)XPS15silvery/");
        favorites.setPrice(100L);
        favorites.setStatus(1);
        int rows = favoritesMapper.addFavorites(favorites);
        System.out.println("addFavorites="+rows);
    }
    
    @Test
    public void updateFavoritesStatus(){
        int rows = favoritesMapper.updateFavoritesStatus(0, 22, 24);
        System.out.println("updateFavoritesStatus="+rows);
    }
}
