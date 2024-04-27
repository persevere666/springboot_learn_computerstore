package com.learn.springboot_learn_computerstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestNatapp {

    @RequestMapping({"","/"})
    public String test(){
        return "Hello, natapp";
    }
}

