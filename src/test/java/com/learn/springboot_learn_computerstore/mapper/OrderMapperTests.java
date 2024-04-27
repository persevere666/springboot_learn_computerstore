package com.learn.springboot_learn_computerstore.mapper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.Order;
import com.learn.springboot_learn_computerstore.entity.OrderItem;
import com.learn.springboot_learn_computerstore.vo.OrderVo;

@SpringBootTest
public class OrderMapperTests {

    @Autowired
    OrderMapper orderMapper;

    // //插入一条order订单数据
    // int insertOneOrder(Order order);

    // //向order_item表中插入一条orderItem数据
    // int insertOneOrderItem(OrderItem orderItem);

    // //根据订单号查询订单
    // Order queryOrderByOid(Integer oid);

    // //根据订单号修改支付状态和支付时间
    // int updateStatusByOidInt(Integer oid, Integer status, Date payTime);

    // //根据oid能从order_item表中找到对应的pid信息
    // List<OrderItem> queryOrderItemByOid(Integer oid);

    // //根据oid查询值对象
    // List<OrderVo> queryOrderVoByOid(Integer oid);

    // //根据uid查询值对象
    // List<OrderVo> queryOrderVoByUid(Integer uid,Integer status);

    @Test
    public void insertOneOrder(){
        Order order = new Order();
        order.setAid(20);
        order.setUid(20);
        order.setRecvName("yyw");
        int rows = orderMapper.insertOneOrder(order);
        System.out.println("insertOneOrder="+rows+",oid="+order.getOid());
    }

    @Test
    public void queryOrderByOid(){
        Order order = orderMapper.queryOrderByOid(40);
        System.out.println("queryOrderByOid="+order);
    }

    @Test
    public void updateStatusByOidInt(){
        orderMapper.updateStatusByOidInt(40, 1, new Date());
    }
    
    @Test
    public void insertOneOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(20);
        orderItem.setPid(20);
        orderItem.setTitle("奋斗");
        int rows = orderMapper.insertOneOrderItem(orderItem);
        System.out.println("insertOneOrderItem="+rows+", id="+orderItem.getId());
    }

    @Test
    public void queryOrderItemByOid(){
        List<OrderItem> orderItems = orderMapper.queryOrderItemByOid(20);
        System.out.println("queryOrderItemByOid="+orderItems);
    }

    @Test
    public void queryOrderVoByOid(){
        List<OrderVo> orderVos = orderMapper.queryOrderVoByOid(39);
        System.out.println("queryOrderVoByOid="+orderVos);
    }

    @Test
    public void queryOrderVoByUid(){
        List<OrderVo> orderVos = orderMapper.queryOrderVoByUid(9,1);
        System.out.println("queryOrderVoByUid="+orderVos);
    }

    
}
