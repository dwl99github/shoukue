package com.soukue.service.common.interceptor;

import com.soukue.service.common.aop.ResponseResult;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author dengwenlong
 * 2020/11/15
 */
//@Component
//public class ResponseResultInterceptor implements HandlerInterceptor {
public class ResponseResultInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            //判断是否在类或方法上加了注解
            if(clazz.isAnnotationPresent(ResponseResult.class)) {
                //设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口中判断
                request.setAttribute(ResponseResult.RESPONSE_RESULT_ANN, clazz.getAnnotation(ResponseResult.class));
            }else if (method.isAnnotationPresent(ResponseResult.class)) {
                //设置此请求返回体，需要包装，往下传递，在ResponseBodyAdvice接口中判断
                request.setAttribute(ResponseResult.RESPONSE_RESULT_ANN, method.getAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
