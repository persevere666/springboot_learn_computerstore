package com.learn.springboot_learn_computerstore.ex;

public class DeleteException extends ServiceException{
    //什么也不返回
    public DeleteException() {
        super();
    }

    //返回异常信息(常用)
    public DeleteException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    protected DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
