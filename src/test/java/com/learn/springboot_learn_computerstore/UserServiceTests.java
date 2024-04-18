package com.learn.springboot_learn_computerstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.springboot_learn_computerstore.entity.User;
import com.learn.springboot_learn_computerstore.ex.ServiceException;
import com.learn.springboot_learn_computerstore.service.IUserService;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService userService;

    @Test
    public void reg() {
        /**
         * 进行插入时可能会出错抛出异常,这时需要捕获异常:
         * 1.选中    User user = new User();
         *           user.setUsername("张7");
         *           user.setPassword("123456");
         *           userService.reg(user);
         *           System.out.println("OK");
         * 2.点击导航栏的Code,然后依次点击SurroundWith->try/catch就可以捕获异常了
         * 3.Exception e没有问题,但这里我们知道是Service层的异常,所以可以改为ServiceException e
         * 4.System.out.println(e.getClass().getSimpleName());获取异常对象再获取类的名称然后输出
         * 5.System.out.println(e.getMessage());输出异常信息(是自己在ServiceException的子类类具体设置的信息)
         */
        try {
            User user = new User();
            user.setUsername("张7");
            user.setPassword("123456");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void login(){
        //因为login方法可能抛出异常,所以应该捕获异常,但是测试时没必要写那么严谨
        try{
            User user = userService.login("test02", "12");
            System.out.println(user);
        }catch(SecurityException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void changePassword() {
        userService.changePassword(5,"管理员","123","321");
    }

    @Test
    public void getByUid() {
        //err是为了让输出信息为红色
        System.err.println(userService.getByUid(7).getUsername());
    }

    @Test
    public void changeInfo() {
        User user = new User();
        //这四个属性值在真实开发中都是在控制层就已经自动封装在User对象中了
        //而uid需要由控制层传给业务层并在业务层封装到user中
        user.setPhone("123456789");
        user.setEmail("123@qq.com");
        user.setUsername("mxy");
        user.setGender(0);
        userService.changeInfo(7,user);
    }

    @Test
    public void changeAvatar() {
        userService.changeAvatar(6,"pathtoavatar","yyw");
    }

}
