package com.learn.springboot_learn_computerstore.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.District;


@SpringBootTest
public class DistrictMapperTests {
    @Autowired
    private DistrictMapper districtMapper;
    
    @Test
    public void findByParent() {
        List<District> list = districtMapper.findByParent("110100");
        for (District district : list) {
            System.out.println(district);
        }
    }

    @Test
    public void findNameByCode() {
        String name = districtMapper.findNameByCode("110101");
        System.out.println(name);
    }

}
