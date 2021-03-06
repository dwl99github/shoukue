package com.soukue.user.controller;

import com.soukue.service.common.aop.ResponseResult;
import com.soukue.pojo.user.User;
import com.soukue.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${server.port}")
    private String port;

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    /***
     * 根据ID查询User数据
     * @param id
     * @return
     */
    @GetMapping("/load/{username}")
    public User findByUsername(@PathVariable String username) {
        //调用 UserService 实现根据主键查询 User
        username = username + port;
        User user = userService.findByUsername(username);
        return user;
//        return new Result<User>(true, StatusCode.OK, "查询成功", user);
    }

    /***
     * 根据ID查询User数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        //调用UserService实现根据主键查询User
        User user = userService.findByUsername(id);
//        System.out.println(restTemplate.getForObject("http://goods/goods/1", String.class));
        restTemplate.getForObject("http://goods/goods/test", String.class);
        return user;
//        return new Result<User>(true, StatusCode.OK, "查询成功", user);
    }

    /***
     * 根据ID查询User数据
     * @return
     */
    @GetMapping("/test")
    public String testRibbon() {
        //ribbon：通过restTemplate访问外部接口，注入restTemplate时需要添加注解 @LoadBalanced
        String forObject = restTemplate.getForObject("http://goods/goods/test", String.class);
        System.out.println(forObject);
        return forObject;
    }
}
