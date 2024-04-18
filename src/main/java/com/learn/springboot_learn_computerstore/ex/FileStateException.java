package com.learn.springboot_learn_computerstore.ex;

public class FileStateException extends FileUploadException{
    //什么也不返回
    public FileStateException() {
        super();
    }

    //返回异常信息(常用)
    public FileStateException(String message) {
        super(message);
    }

    //返回异常信息和异常对象(常用)
    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
