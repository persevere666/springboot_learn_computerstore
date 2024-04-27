package com.learn.springboot_learn_computerstore.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.Product;

@SpringBootTest
public class ProductMapperTests {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void queryTheNewProduct(){
        List<Product> products = productMapper.queryTheNewProduct();
        System.out.println(products);
    }

    @Test
    public void findHotList(){
        List<Product> products = productMapper.queryHotList();
        System.out.println(products);
    }

    @Test
    public void queryProductById(){
        Product product = productMapper.queryProductById(10000001);
        System.out.println(product);
    }
    @Test
    public void test(){
        List<Product> products = productMapper.queryProductByTitle("得力");
        System.out.println(products);
    }
}
