package com.learn.springboot_learn_computerstore.ex;

public class AddressCountLimitException extends ServiceException{

    //什么也不返回
    public AddressCountLimitException() {
        super();
    }

    //返回异常信息(常用)
    public AddressCountLimitException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
