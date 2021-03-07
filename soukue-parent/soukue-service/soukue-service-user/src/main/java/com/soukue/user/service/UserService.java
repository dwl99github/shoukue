package com.soukue.user.service;

import com.soukue.pojo.user.User;

/**
 * User业务层接口
 * @author soukue
 * 2020/11/15
 */
public interface UserService {
    User findByUsername(String username);
}
