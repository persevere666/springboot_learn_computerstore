package com.learn.springboot_learn_computerstore.ex;

public class ProductNotFoundException extends ServiceException{
    //什么也不返回
    public ProductNotFoundException() {
        super();
    }

    //返回异常信息(常用)
    public ProductNotFoundException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
