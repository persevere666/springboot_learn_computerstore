package com.learn.springboot_learn_computerstore;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.User;
import com.learn.springboot_learn_computerstore.mapper.UserMapper;

@SpringBootTest
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void insert(){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println(rows);
    }

    @Test
    public void findByUsername() {
        User user = userMapper.findByUsername("张三");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(
            5,
            "123",
            "管理员",
            new Date());
    }

    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(5));
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(6);
        user.setPhone("13333688");
        user.setEmail("1454@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid() {
        userMapper.updateAvatarByUid(
            11,
            "abc",
            "mxy",
            new Date());
    }
    
}
