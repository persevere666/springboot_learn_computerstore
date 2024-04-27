package com.learn.springboot_learn_computerstore.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVo implements Serializable{

    private Integer cid;
    private Integer pid;
    private Integer uid;
    private Long price;
    private Integer num;
    private String title;
    private String image;
    private String realPrice;
    
}
