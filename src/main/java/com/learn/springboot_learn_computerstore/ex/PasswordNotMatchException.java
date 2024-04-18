package com.learn.springboot_learn_computerstore.ex;

public class PasswordNotMatchException extends ServiceException{
    //什么也不返回
    public PasswordNotMatchException() {
        super();
    }

    //返回异常信息(常用)
    public PasswordNotMatchException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    protected PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
