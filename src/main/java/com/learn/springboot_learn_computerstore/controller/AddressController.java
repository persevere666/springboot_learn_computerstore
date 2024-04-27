package com.learn.springboot_learn_computerstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot_learn_computerstore.entity.Address;
import com.learn.springboot_learn_computerstore.ex.InsertException;
import com.learn.springboot_learn_computerstore.service.IAddressService;
import com.learn.springboot_learn_computerstore.util.JsonResult;

import jakarta.servlet.http.HttpSession;

@RequestMapping("address")
@RestController
public class AddressController extends BaseController{

    @Autowired
    private IAddressService addressService;

    // @RequestMapping("add_new_address")
    // public JsonResult<Void> addNewAddress(Address address, HttpSession session) {
    //     Integer uid = getUidFromSession(session);
    //     String username = getUsernameFromSession(session);
    //     addressService.addNewAddress(uid,username,address);
    //     return new JsonResult<>(OK);
    // }

    /**
     * Description : 处理用户新增地址
     * @date 2022/7/13
     * @param address 用户地址信息
     * @param session 项目启动自动生成的HttpSession对象
     * @return void
     **/
    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address,HttpSession session){

        //从session中取出uid和用户名
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        //调用业务层方法，新增地址
        addressService.addNewAddress(uid,username,address);
        //addressService.addAddress(address,username,uid);
        return new JsonResult<>(OK);
    }
    
    @RequestMapping({"","/"})
    public JsonResult<List<Address>> queryAllAddress(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<>(OK,data);
    }

    //RestFul风格的请求编写
    //@PostMapping("/setAddress")
    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(
        @PathVariable("aid") Integer aid,HttpSession session) {
        addressService.setDefault(
            aid,
            getUidFromSession(session),
            getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
    //@PostMapping("/deleteAddress")
    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid,HttpSession session) {
        addressService.delete(
            aid,
            getUidFromSession(session),
            getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }


    //@GetMapping("/queryOneAddress")
    @RequestMapping("/query_address_by_aid")
    public JsonResult<Address> queryAddressByAid(Integer aid){
        Address address = addressService.queryAddressByAid(aid);
        //过滤部分不需要的字段
        address.setModifiedTime(null);
        address.setModifiedUser(null);
        address.setCreatedTime(null);
        address.setCreatedUser(null);
        address.setIsDelete(0);

        return new JsonResult<>(OK,address);
    }

    //@PostMapping("/updateAddress")
    @RequestMapping("/update_address")
    public JsonResult<Void> updateAddress(Address address,HttpSession session){

        //取出session中用户名
        String modifiedUser = getUsernameFromSession(session);

        int result = addressService.updateAddress(address, modifiedUser);

        if (result == 0){
            throw new InsertException("修改地址时，服务器或数据库异常");
        }
        return new JsonResult<>(OK);
    }

    
    
}
