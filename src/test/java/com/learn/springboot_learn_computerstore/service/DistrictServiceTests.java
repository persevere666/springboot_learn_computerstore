package com.learn.springboot_learn_computerstore.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.District;

@SpringBootTest
public class DistrictServiceTests {
    @Autowired
    private IDistrictService districtService;

    @Test
    public void getByParent() {
        //86代表中国,所有的省父代码号都是86
        List<District> list = districtService.getByParent("86");
        for (District district : list) {
            System.out.println(district);
        }
    }
    
}
