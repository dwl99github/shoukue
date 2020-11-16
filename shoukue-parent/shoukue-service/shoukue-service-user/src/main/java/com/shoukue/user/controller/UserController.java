package com.shoukue.user.controller;

import com.shoukue.service.common.aop.ResponseResult;
import com.shoukue.user.pojo.User;
import com.shoukue.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author dengwenlong
 * 2020/11/15
 */
@RestController
@RequestMapping("/user")
@ResponseResult
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    /***
     * 根据ID查询User数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        //调用UserService实现根据主键查询User
        User user = userService.findById(id);
//        System.out.println(restTemplate.getForObject("http://goods/goods/1", String.class));
        restTemplate.getForObject("http://goods/goods/test", String.class);
        return user;
//        return new Result<User>(true, StatusCode.OK, "查询成功", user);
    }

    /***
     * 根据ID查询User数据
     * @param id
     * @return
     */
    @GetMapping("/test")
    public String testRibbon() {
//        User user = new User();
//        user.setUsername(restTemplate.getForObject("http://goods/goods/test", String.class));
        return restTemplate.getForObject("http://goods/goods/test", String.class);
    }
}
