package com.learn.springboot_learn_computerstore.ex;

public class UsernameNotFoundException extends ServiceException{
    //什么也不返回
    public UsernameNotFoundException() {
        super();
    }

    //返回异常信息(常用)
    public UsernameNotFoundException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UsernameNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
