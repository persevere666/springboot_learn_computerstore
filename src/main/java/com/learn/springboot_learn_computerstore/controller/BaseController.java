package com.learn.springboot_learn_computerstore.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.springboot_learn_computerstore.ex.AccessDeniedException;
import com.learn.springboot_learn_computerstore.ex.AddressCountLimitException;
import com.learn.springboot_learn_computerstore.ex.AddressNotFoundException;
import com.learn.springboot_learn_computerstore.ex.CartInfoNotExistsException;
import com.learn.springboot_learn_computerstore.ex.DeleteException;
import com.learn.springboot_learn_computerstore.ex.FileEmptyException;
import com.learn.springboot_learn_computerstore.ex.FileSizeException;
import com.learn.springboot_learn_computerstore.ex.FileStateException;
import com.learn.springboot_learn_computerstore.ex.FileTypeException;
import com.learn.springboot_learn_computerstore.ex.FileUploadException;
import com.learn.springboot_learn_computerstore.ex.FileUploadIOException;
import com.learn.springboot_learn_computerstore.ex.InsertException;
import com.learn.springboot_learn_computerstore.ex.PasswordNotMatchException;
import com.learn.springboot_learn_computerstore.ex.ProductNotFoundException;
import com.learn.springboot_learn_computerstore.ex.ServiceException;
import com.learn.springboot_learn_computerstore.ex.UpdateException;
import com.learn.springboot_learn_computerstore.ex.UsernameDuplicatedException;
import com.learn.springboot_learn_computerstore.ex.UsernameNotFoundException;
import com.learn.springboot_learn_computerstore.ex.ValidCodeNotMatchException;
import com.learn.springboot_learn_computerstore.util.JsonResult;

import jakarta.servlet.http.HttpSession;

public class BaseController {

    //操作成功的状态码
    public static final int OK = 200;

    /**
     * 1.@ExceptionHandler表示该方法用于处理捕获抛出的异常
     * 2.什么样的异常才会被这个方法处理呢?所以需要ServiceException.class,这样的话只要是抛出ServiceException异常就会被拦截到handleException方法,此时handleException方法就是请求处理方法,返回值就是需要传递给前端的数据
     * 3.被ExceptionHandler修饰后如果项目发生异常,那么异常对象就会被自动传递给此方法的参数列表上,所以形参就需要写Throwable e用来接收异常对象
     */
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            //result.setMessage("用户名已经被占用");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            //result.setMessage("插入数据时产生未知的异常");
        }else if (e instanceof UsernameNotFoundException) {
            result.setState(4001);
            //result.setMessage("用户数据不存在的异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            //result.setMessage("用户名密码错误的异常");
        }else if (e instanceof ValidCodeNotMatchException){
            result.setState(4003);
        }else if (e instanceof UpdateException) {
            result.setState(5001);
            //result.setMessage("更新数据时产生未知的异常");
        }else if (e instanceof DeleteException) {
            result.setState(5002);
            //result.setMessage("删除数据时产生未知的异常");
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }else if (e instanceof AddressCountLimitException) {
            result.setState(7000);
            //result.setMessage("用户的收货地址超出上限的异常");
        }else if (e instanceof AddressNotFoundException) {
            result.setState(7001);
            //result.setMessage("用户的收货地址数据不存在的异常");
        } else if (e instanceof AccessDeniedException) {
            result.setState(7002);
            //result.setMessage("收货地址数据非法访问的异常");
        }else if (e instanceof ProductNotFoundException) {
            result.setState(8000);
            //result.setMessage("访问的商品数据不存在的异常");
        }else if (e instanceof CartInfoNotExistsException) {
            result.setState(9000);
            //result.setMessage("查询的cart数据不存在");
        }
        
        return result;
    }

     /**
     * 获取session对象中的uid
     * @param session session对象
     * @return 当前登录的用户uid的值
     */
    public final Integer getUidFromSession(HttpSession session) {
        //getAttribute返回的是Object对象,需要转换为字符串再转换为包装类
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    public final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
    //

}
