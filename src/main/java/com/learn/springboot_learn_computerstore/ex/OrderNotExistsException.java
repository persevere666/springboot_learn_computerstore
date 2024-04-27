package com.learn.springboot_learn_computerstore.ex;

public class OrderNotExistsException extends ServiceException{
    //什么也不返回
    public OrderNotExistsException() {
        super();
    }

    //返回异常信息(常用)
    public OrderNotExistsException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public OrderNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderNotExistsException(Throwable cause) {
        super(cause);
    }

    protected OrderNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
