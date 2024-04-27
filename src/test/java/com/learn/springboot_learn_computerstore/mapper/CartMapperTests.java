package com.learn.springboot_learn_computerstore.mapper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.Cart;
import com.learn.springboot_learn_computerstore.vo.CartVo;

@SpringBootTest
public class CartMapperTests {

    @Autowired
    private CartMapper cartMapper;

    @Test
    public void queryCartByUidAndPid() {
        Cart cart = cartMapper.queryCartByUidAndPid(11, 10000001);
        System.out.println(cart);
    }

    @Test
    public void updateCartInfo(){
        Cart cart = new Cart();
        cart.setCid(20);
        cart.setNum(1);
        cart.setCreatedUser("小小");
        cart.setCreatedTime(new Date());
        int rows = cartMapper.updateCartInfo(cart);
        System.out.println("updateCartInfo="+rows);
    }

    @Test
    public void addCart() {
        Cart cart = new Cart();
        cart.setUid(11);
        cart.setPid(10000001);
        cart.setPrice(4L);//长整型
        cart.setNum(3);
        cart.setCreatedTime(new Date());
        cart.setCreatedUser("yy");
        cart.setModifiedUser("haha");
        cart.setModifiedTime(new Date());
        int rows = cartMapper.addCart(cart);
        System.out.println("addCart="+rows);
    }

    @Test
    public void queryAllCartsByUid(){
        List<CartVo> cartVoList = cartMapper.queryAllCartsByUid(11);
        System.out.println(cartVoList);
    }


    @Test
    public void queryCartByCid(){
        Cart cart = cartMapper.queryCartByCid(20);
        System.out.println(cart);
    }

    @Test
    public void UpdateCartNumByCid() {
        int rows = cartMapper.UpdateCartNumByCid(6, "张三", new Date(),27);
        System.out.println("UpdateCartNumByCid="+rows);
    }

    @Test
    public void queryCartVoByCid(){
       CartVo cartVo = cartMapper.queryCartVoByCid(20);
       System.out.println(cartVo);
    }

    @Test
    public void deleteCartByCid(){
        int rows = cartMapper.deleteCartByCid(31);
        System.out.println("deleteCartByCid="+rows);
    }

    @Test
    public void deleteCartByUidAndPid(){
        int rows = cartMapper.deleteCartByUidAndPid(13, 10000001);
        System.out.println("deleteCartByUidAndPid="+rows);
    }
    
}
