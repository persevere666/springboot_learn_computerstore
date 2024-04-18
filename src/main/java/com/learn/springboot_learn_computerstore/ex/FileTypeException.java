package com.learn.springboot_learn_computerstore.ex;

public class FileTypeException extends FileUploadException{
    //什么也不返回
    public FileTypeException() {
        super();
    }

    //返回异常信息(常用)
    public FileTypeException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }   
}
