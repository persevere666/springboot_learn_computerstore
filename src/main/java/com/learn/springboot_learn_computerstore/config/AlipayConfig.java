package com.learn.springboot_learn_computerstore.config;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hcxs1986
 * @version 1.0
 * @description: 支付宝沙箱支付配置类
 * @date 2022/7/25 1:29
 */
@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfig {
    //自己的appId
    private String appId;
    //应用私有秘钥
    private String appPrivateKey;
    //支付宝公钥
    private String alipayPublicKey; 
    //异步回调地址
    private String notifyUrl;//"http://1.14.176.219:8080/alipay/notifyNotice";
    //同步回调地址
    private String returnUrl; // "http://1.14.176.219:8080/alipay/returnNotice";
    //推荐使用这个秘钥
    private String signType;// = "RSA2";
    //使用的编码格式
    private String charset; // = "utf-8";
    //支付宝默认网关
    private String gatewayUrl;// = "https://openapi.alipaydev.com/gateway.do";

    @PostConstruct
    public void init() {
      // 设置参数（全局只需设置一次）
      Config config = new Config();
      config.protocol = "https";
      config.gatewayHost = "openapi.alipaydev.com";
      config.signType = "RSA2";
      config.appId = this.appId;
      config.merchantPrivateKey = this.appPrivateKey;
      config.alipayPublicKey = this.alipayPublicKey;
      config.notifyUrl = this.notifyUrl;
      Factory.setOptions(config);
      System.out.println("=======支付宝SDK初始化成功=======");
    }

}
