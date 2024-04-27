package com.learn.springboot_learn_computerstore.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.learn.springboot_learn_computerstore.entity.Product;

@Mapper
public interface ProductMapper {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> queryHotList();
    
    /**
     * Description : 查询最新上架的商品进行展示
     * @date 2022/7/16
     * @return java.util.List<top.year21.computerstore.entity.Product>
     **/
    List<Product> queryTheNewProduct();

    /**
     * Description : 根据指定商品id进行商品查询
     * @date 2022/7/16
     * @param id 商品id
     * @return top.year21.computerstore.entity.Product
     **/
    Product queryProductById(Integer id);

    /**
     * Description : 根据指定的名称关键字进行模糊查询
     * @date 2022/7/22
     * @param title 要查询的商品名称关键字
     * @return java.util.List<top.year21.computerstore.entity.Product>
     **/
    List<Product> queryProductByTitle(String title);


}
