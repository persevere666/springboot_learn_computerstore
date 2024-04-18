package com.learn.springboot_learn_computerstore.ex;

public class FileUploadException extends RuntimeException{
    //什么也不返回
    public FileUploadException() {
        super();
    }

    //返回异常信息(常用)
    public FileUploadException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
