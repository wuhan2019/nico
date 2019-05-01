package com.tico.tico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/success").setViewName("success");//登录/注册成功测试页面
        registry.addViewController("/login").setViewName("login");//登录页面
        registry.addViewController("/fail").setViewName("fail");//登录/注册失败测试页面
        registry.addViewController("/signup").setViewName("signup");//注册页面
    }

    //fff
    //拦截器，后面再加
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//    }
}
