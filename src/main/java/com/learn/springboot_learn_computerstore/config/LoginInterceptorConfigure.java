package com.learn.springboot_learn_computerstore.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import com.learn.springboot_learn_computerstore.constant.Constant;
import com.learn.springboot_learn_computerstore.interceptor.LoginInterceptor;

@Configuration
public class LoginInterceptorConfigure implements WebMvcConfigurer{
    @Override
    //配置拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //1.创建自定义的拦截器对象
        HandlerInterceptor interceptor =  new LoginInterceptor();
        //2.配置白名单并存放在一个List集合
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/user/reg");
        patterns.add("/user/login");

        //registry.addInterceptor(interceptor);完成拦截
        // 器的注册,后面的addPathPatterns表示拦截哪些url
        //这里的参数/**表示所有请求,再后面的excludePathPatterns表
        // 示有哪些是白名单,且参数是列表
        registry.addInterceptor(interceptor)
                //拦截所有请求
                .addPathPatterns("/**")
                //放行静态资源
                .excludePathPatterns("/web/login.html","/web/index.html",
                                    "/web/register.html","/web/product.html",
                                    "/web/components/**","/web/search.html",
                                    "/css/**","/bootstrap3/**", "/images/**","/js/**")
                //放行请求接口和支付宝沙箱接口
                .excludePathPatterns("/user/**","/address/**","/file/**","/district/**",
                                    "/product/**","/cart/**","/order/**","/kaptcha/**",
                                    "/alipay/**")
                //不放行/error页面有可能导致白名单失效假象
                .excludePathPatterns("/error")
                //.excludePathPatterns(patterns)
                ;
        
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
        .addResourceLocations("file:" + Constant.FILE_UPLOAD_DIR);
	}
    
}
