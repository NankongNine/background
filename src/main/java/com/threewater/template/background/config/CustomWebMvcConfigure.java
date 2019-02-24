package com.threewater.template.background.config;

import com.threewater.template.background.interceptor.TestIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //路径拦截用* 拦截路径最后需要用** 拦截器是先注册，先被拦截
        registry.addInterceptor(new TestIntercepter()).addPathPatterns("/hello/*/**");
        //.excludePathPatterns("/api2/xxx/**"); //拦截全部 /*/*/**

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
