package com.shoukue.user.controller;

import com.netflix.discovery.converters.Auto;
import com.shoukue.service.common.aop.ResponseResult;
import com.shoukue.service.common.entity.Result;
import com.shoukue.service.common.entity.StatusCode;
import com.shoukue.user.pojo.User;
import com.shoukue.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /***
     * 根据ID查询User数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        //调用UserService实现根据主键查询User
        User user = userService.findById(id);
        return user;
//        return new Result<User>(true, StatusCode.OK, "查询成功", user);
    }
}
