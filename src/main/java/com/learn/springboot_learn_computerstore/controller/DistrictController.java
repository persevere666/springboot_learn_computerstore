package com.learn.springboot_learn_computerstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.springboot_learn_computerstore.service.IDistrictService;
import com.learn.springboot_learn_computerstore.util.JsonResult;
import com.learn.springboot_learn_computerstore.entity.District;

@RequestMapping("district")
@RestController
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;

    /**
     * 请求路径和父路径相同时用@RequestMapping({"/",""}),表
     * 示districts后面跟/或者什么也不跟都会进入这个方法
     * 点进RequestMapping发现参数类型是String[],且传入一
     * 个路径时默认有{},传入一个以上路径时需要手动添加{}
     */
    @GetMapping("/parent")
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK,data);
    }
    @GetMapping
    public String queryDistrictNameByCode(String code){
        return districtService.getNameByCode(code);
    }
    
}
