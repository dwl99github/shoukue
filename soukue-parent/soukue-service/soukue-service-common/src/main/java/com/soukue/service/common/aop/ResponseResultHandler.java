package com.soukue.service.common.aop;

import com.soukue.service.common.entity.Result;
import com.soukue.service.common.entity.StatusCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author soukue
 * 2020/11/15
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //请求中是否包含包装注解，没包含不需要重写返回体，直接返回false
        ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(ResponseResult.RESPONSE_RESULT_ANN);
        return Objects.nonNull(responseResultAnn);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if(((Objects.requireNonNull(methodParameter.getMethod())).getReturnType() == String.class)){
            return o;
        }
        //重定返回体
        Result<Object> result = new Result<>(true, StatusCode.OK, "查询成功", o);
        return result;
    }
}
