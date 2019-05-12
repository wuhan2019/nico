package com.tico.tico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/phone").setViewName("phone");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/phone").setViewName("phone");
        registry.addViewController("/phoneDetails").setViewName("phoneDetails");
        registry.addViewController("/phoneSearch").setViewName("phoneSearch");
        registry.addViewController("/phoneCompare").setViewName("phoneCompare");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/product_pic/**").addResourceLocations("product_pic");
//    }

    //fff
    //拦截器，后面再加
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//    }
}
