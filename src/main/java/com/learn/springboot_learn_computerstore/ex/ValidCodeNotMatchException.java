package com.learn.springboot_learn_computerstore.ex;

public class ValidCodeNotMatchException extends ServiceException{
    //什么也不返回
    public ValidCodeNotMatchException() {
        super();
    }

    //返回异常信息(常用)
    public ValidCodeNotMatchException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public ValidCodeNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidCodeNotMatchException(Throwable cause) {
        super(cause);
    }

    protected ValidCodeNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
