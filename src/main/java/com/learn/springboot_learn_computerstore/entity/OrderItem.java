package com.learn.springboot_learn_computerstore.entity;

import lombok.*;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 对应数据表t_order_item的实体类
 * @date 2022/7/18 17:41
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends BaseEntity{
    private Integer id;
    private Integer oid;
    private Integer pid;
    private String title;
    private String image;
    private Long price;
    private Integer num;
}
