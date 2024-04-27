package com.learn.springboot_learn_computerstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;


@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseEntity{

    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    
}
