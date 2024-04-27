package com.learn.springboot_learn_computerstore.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.pagehelper.PageInfo;
import com.learn.springboot_learn_computerstore.entity.Product;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private IProductService productService;

    @Test
    public void queryHotList(){
        List<Product> products = productService.queryHotList();
        System.out.println(products);
    }
    @Test
    public void queryTheNewProduct(){
        List<Product> products = productService.queryTheNewProduct();
        System.out.println(products);
    }

    @Test
    public void queryProductById(){
        Product product = productService.queryProductById(10000001);
        System.out.println(product);
    }

    @Test
    public void queryProductByTitle(){
        PageInfo<Product> pageInfo = productService.queryProductByTitle(2,2,"得力");
        System.out.println(pageInfo);
    }
    
}
