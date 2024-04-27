package com.learn.springboot_learn_computerstore.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District implements Serializable{
    private Integer id;
    private String parent;
    private String code;
    private String name;
}
