package com.learn.springboot_learn_computerstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.learn.springboot_learn_computerstore.entity.Product;
import com.learn.springboot_learn_computerstore.ex.ProductBadStatusException;
import com.learn.springboot_learn_computerstore.ex.ProductNotFoundException;
import com.learn.springboot_learn_computerstore.mapper.ProductMapper;
import com.learn.springboot_learn_computerstore.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryHotList() {
        List<Product> list = productMapper.queryHotList();
        for (Product product : list) {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }
        return list;
    }

    /**
     * Description : 处理查询最新商品的具体逻辑
     * @date 2022/7/16
     * @return java.util.List<top.year21.computerstore.entity.Product>
     **/
    @Override
    public List<Product> queryTheNewProduct() {
        return productMapper.queryTheNewProduct();
    }
    //
    @Override
    public Product queryProductById(Integer id) {
        Product product = productMapper.queryProductById(id);

        if (product == null){
            throw new ProductNotFoundException("无此商品信息，查询失败");
        }

        if (product.getStatus() == 2){
            throw new ProductBadStatusException("商品已下架");
        }

        if (product.getStatus() == 3){
            throw new ProductBadStatusException("商品已删除");
        }
        //无任何异常则返回数据
        return product;
    }

    /**
     * Description : 根据名称进行模糊查询的具体逻辑
     * @date 2024/04/26
     * @param title 查询的关键字
     * @return com.github.pagehelper.PageInfo<Product>
     **/
    @Override
    public PageInfo<Product> queryProductByTitle(Integer pageNum, Integer pageSize,String title) {
        //开启分页功能
        PageHelper.startPage(pageNum,pageSize);
        //调用持久层方法进行查询
        List<Product> products = productMapper.queryProductByTitle(title);
        //返回分页数据
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }
    
}
