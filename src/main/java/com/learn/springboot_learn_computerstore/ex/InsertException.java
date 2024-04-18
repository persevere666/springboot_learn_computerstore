package com.learn.springboot_learn_computerstore.ex;

public class InsertException extends ServiceException{
    //什么也不返回
    public InsertException() {
        super();
    }

    //返回异常信息(常用)
    public InsertException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
