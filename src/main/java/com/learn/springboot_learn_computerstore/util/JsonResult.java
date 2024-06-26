package com.learn.springboot_learn_computerstore.util;

import java.io.Serializable;

import lombok.Data;

//因为所有的响应的结果都采用Json格式的数据进行响应,所以需要实现Serializable接口
@Data
public class JsonResult<E> implements Serializable {
    //状态码
    private Integer state;
    //描述信息
    private String message;
    //数据类型不确定,用E表示任何的数据类型,一个类里如果声明的有泛型的数据类型,类也要声明为泛型
    private E data;
	
    //无参构造
    public JsonResult() {
    }

    //将状态码传给构造方法初始化对象
    public JsonResult(Integer state) {
        this.state = state;
    }


    //将状态码和数据传给构造方法初始化对象
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    //如果有异常,直接将异常传递给构造方法初始化对象
    public JsonResult(Throwable e) {
        this.message=e.getMessage();
    }
    /**以及属性的get和set方法*/
}
