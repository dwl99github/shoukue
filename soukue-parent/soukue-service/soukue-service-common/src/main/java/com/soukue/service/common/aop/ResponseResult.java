package com.soukue.service.common.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记方法的返回值，是否需要包装
 * @author dengwenlong 2020/11/15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
    public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";
}
