package com.learn.springboot_learn_computerstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.Address;

@SpringBootTest
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress() {
        Address address = new Address();
        address.setPhone("175726");
        address.setName("男朋友");
        addressService.addNewAddress(6,"mxy",address);
    }

    @Test
    public void setDefault() {
        addressService.setDefault(23,6,"管理员");
    }

    @Test
    public void delete() {
        addressService.delete(20,12,"管理员");
    }
}
