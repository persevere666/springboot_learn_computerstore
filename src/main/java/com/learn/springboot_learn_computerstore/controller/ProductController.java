package com.learn.springboot_learn_computerstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.learn.springboot_learn_computerstore.entity.Product;
import com.learn.springboot_learn_computerstore.service.IProductService;
import com.learn.springboot_learn_computerstore.util.JsonResult;

import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController{

    @Autowired
    private IProductService productService;

    @RequestMapping("/hotProduct")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.queryHotList();
        return new JsonResult<List<Product>>(OK, data);
    }

    /**
     * Description : 处理展示最新商品的请求
     * @date 2024/4/24
     * @return 
     **/
    @GetMapping("/newProduct")
    public JsonResult<List<Product>> queryNewProduct(){
        //查询对应商品
        List<Product> products = productService.queryTheNewProduct();

        return new JsonResult<>(OK,products);
    }

    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        Product data = productService.queryProductById(id);
        return new JsonResult<Product>(OK, data);
    }

    /**
     * Description : 处理商品id查询该商品信息的请求
     * @date 2024/04/26
     * @param id 商品id
     * @return top.year21.computerstore.utils.JsonResult<top.year21.computerstore.entity.Product>
     **/
    @GetMapping("/{id}")
    public JsonResult<Product> queryProductById(@PathVariable(value = "id",required = false) Integer id){
        Product product = productService.queryProductById(id);
        return new JsonResult<>(OK,product);
    }

    /**
     * Description : 处理根据产品关键字进行模糊查询的请求
     * @date 2024/04/26
     * @param pageNum 当前页
     * @param pageSize 每页显示数
     * @param title 查询的关键字
     * @return top.year21.computerstore.utils.JsonResult<com.github.pagehelper.PageInfo<top.year21.computerstore.entity.Product>>
     **/
    @GetMapping("/{pageNum}/{pageSize}/{title}")
    public JsonResult<PageInfo<Product>> quertByTitle(@PathVariable("pageNum") Integer pageNum,
                                                      @PathVariable("pageSize") Integer pageSize,
                                                      @PathVariable("title") String title){
        PageInfo<Product> lists = productService.queryProductByTitle(pageNum, pageSize, title);
        return new JsonResult<>(OK,lists);
    }
    
}
