package com.soukue.service.common.config;

import com.soukue.service.common.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMvcConfigurerAdapter 方法过时，有两种替代方案：
 * 1、继承WebMvcConfigurationSupport
 * 2、实现WebMvcConfigurer
 * 但是继承WebMvcConfigurationSupport会让Spring-boot对mvc的自动配置失效。
 * 根据项目情况选择。现在大多数项目是前后端分离，并没有对静态资源有自动配置的需求所以继承WebMvcConfigurationSupport也未尝不可。
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