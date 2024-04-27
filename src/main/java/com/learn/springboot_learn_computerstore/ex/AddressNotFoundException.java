package com.learn.springboot_learn_computerstore.ex;

public class AddressNotFoundException extends ServiceException{
    //什么也不返回
    public AddressNotFoundException() {
        super();
    }

    //返回异常信息(常用)
    public AddressNotFoundException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
