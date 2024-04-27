package com.learn.springboot_learn_computerstore.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.learn.springboot_learn_computerstore.entity.Product;

public interface IProductService {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> queryHotList();

    //查询最新商品的前五项的抽象方法
    List<Product> queryTheNewProduct();

    //查询指定id商品的抽象方法
    Product queryProductById(Integer id);

    //根据名称进行模糊查询的抽象方法
    PageInfo<Product>  queryProductByTitle(Integer pageNum, Integer pageSize,String title);

}
