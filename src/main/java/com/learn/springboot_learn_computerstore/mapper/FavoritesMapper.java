package com.learn.springboot_learn_computerstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.learn.springboot_learn_computerstore.entity.Favorites;

@Mapper
public interface FavoritesMapper {
    
     //新增收藏商品的抽象方法
     int addFavorites(Favorites favorites);

     //根据uid和收藏商品状态查询收藏的商品信息
     List<Favorites> queryFavoritesByUidAndStatus(Integer uid,Integer status);
 
     //根据收藏商品pid和用户uid取消对应商品收藏
     int updateFavoritesStatus(Integer status,Integer fid,Integer uid);
 
    
}
