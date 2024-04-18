package com.learn.springboot_learn_computerstore.ex;

public class FileSizeException extends FileUploadException{

    //什么也不返回
     public FileSizeException() {
        super();
    }

    //返回异常信息(常用)
    public FileSizeException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
