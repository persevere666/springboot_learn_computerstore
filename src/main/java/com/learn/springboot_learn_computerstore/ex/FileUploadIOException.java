package com.learn.springboot_learn_computerstore.ex;

public class FileUploadIOException extends FileUploadException{
     //什么也不返回
     public FileUploadIOException() {
        super();
    }

    //返回异常信息(常用)
    public FileUploadIOException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    } 
    
}
