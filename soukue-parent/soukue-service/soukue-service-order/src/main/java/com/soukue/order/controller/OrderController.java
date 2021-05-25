package com.soukue.order.controller;

import com.soukue.order.service.OrderService;
import com.soukue.service.common.aop.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author soukue
 * 2020/11/15
 */
@RestController
@RequestMapping("/order")
@ResponseResult
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Value("${server.port}")
    String port;

    @GetMapping("/test")
    public String test(Map<String, Object> paramMap) {
        System.out.println(paramMap);
        return "goodsService port!!!!!!!12:" + port;
//        return new Result<User>(true, StatusCode.OK, "查询成功", user);
    }
}
