package com.learn.springboot_learn_computerstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.Constants;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


@Slf4j
@RestController
@RequestMapping("/kaptcha")
public class KaptchaController {
    @Autowired
    private Producer producer;

    @GetMapping("/kaptcha-image")
    public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = producer.createText();
        log.info("******************当前验证码为：{}******************", capText);
        // 将验证码存于session中
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = producer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // 向页面输出验证码
        ImageIO.write(bi, "jpg", out);
        
        try {
            // 清空缓存区
            out.flush();
        } finally {
            // 关闭输出流
            out.close();
        }
    }
    
}
