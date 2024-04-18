package com.learn.springboot_learn_computerstore.ex;

public class FileEmptyException extends FileUploadException{
     //什么也不返回
     public FileEmptyException() {
        super();
    }

    //返回异常信息(常用)
    public FileEmptyException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
