package com.shoukue.user.service.impl;

import com.shoukue.user.pojo.User;
import com.shoukue.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author dengwenlong
 * 2020/11/15
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findById(String id) {
        User user = new User();
        user.setName("dwl");
        user.setUsername("dwl99");
        user.setPassword("123456");
        return user;
    }
}
