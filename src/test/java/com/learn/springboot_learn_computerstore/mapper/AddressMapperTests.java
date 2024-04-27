package com.learn.springboot_learn_computerstore.mapper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.Address;
import com.learn.springboot_learn_computerstore.mapper.AddressMapper;

@SpringBootTest
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(1);
        address.setPhone("133336");
        address.setName("女朋友");
        addressMapper.insert(address);
    }
    @Test
    public void countByUid() {
        Integer count = addressMapper.countByUid(1);
        System.out.println(count);
    }

    @Test
    public void findByUid () {
        List<Address> list = addressMapper.findByUid(12);
        System.out.println(list);
    }
    
    
    @Test
    public void findByAid() {
        System.err.println(addressMapper.findByAid(1));
    }

    @Test
    public void updateNonDefault() {
        System.out.println(addressMapper.updateNonDefault(12));//有几条数据影响行数就输出几
    }

    @Test
    public void updateDefaultByAid() {
        addressMapper.updateDefaultByAid(14,"明明",new Date());
    }

    @Test
    public void deleteByAid() {
        addressMapper.deleteByAid(23);
    }

    @Test
    public void findLastModified() {
        System.out.println(addressMapper.findLastModified(12));
    }


    @Test
    public void queryUserAddressByAid(){
        Address address = addressMapper.queryUserAddressByAid(25);
        System.out.println(address);
    }

    @Test
    public void updateUserAddressByAid(){
        Address address = addressMapper.queryUserAddressByAid(25);
        address.setAddress("紫荆花园");
        int rows = addressMapper.updateUserAddressByAid(address);
        System.out.println("updateUserAddressByAid="+rows);
    }
}
