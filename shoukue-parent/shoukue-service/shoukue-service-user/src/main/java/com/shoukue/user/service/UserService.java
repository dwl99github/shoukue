package com.shoukue.user.service;

import com.shoukue.user.pojo.User;

/**
 * User业务层接口
 * @author dengwenlong
 * 2020/11/15
 */
public interface UserService {
    User findByUsername(String username);
}
