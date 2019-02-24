package com.threewater.template.background.config;

import com.threewater.template.background.interceptor.TestIntercepter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration 该adapter由于JDK1.8之后，接口支持default方法，已废弃了
public class CustomOldWebMvcConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestIntercepter()).addPathPatterns("/api/v1/");

        super.addInterceptors(registry);
    }
}
