package com.soukue.order.controller;

import com.soukue.order.service.OrderService;
import com.soukue.service.common.aop.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /***
     * 根据ID查询User数据
     * @param id
     * @return
     */
    @GetMapping("/test")
    public String test() {
        return "goodsService port!!!!!!!12:" + port;
//        return new Result<User>(true, StatusCode.OK, "查询成功", user);
    }
}
