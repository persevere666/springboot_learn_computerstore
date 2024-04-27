package com.learn.springboot_learn_computerstore.ex;

public class AccessDeniedException extends ServiceException{
    //什么也不返回
    public AccessDeniedException() {
        super();
    }

    //返回异常信息(常用)
    public AccessDeniedException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    protected AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
