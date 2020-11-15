package com.shoukue.service.common.config;

import com.shoukue.service.common.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 继承WebMvcConfigurationSupport会让Spring-boot对mvc的自动配置失效
 * @author dengwenlong
 * 2020/11/15
 */
@Configuration
public class WebAppConfigurerAdapter extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个，选择拦截所有请求地址，进入后判断是否有加注解
        registry.addInterceptor(new ResponseResultInterceptor()).addPathPatterns("/**");
    }
}