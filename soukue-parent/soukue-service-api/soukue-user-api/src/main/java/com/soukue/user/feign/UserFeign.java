package com.soukue.user.feign;

import com.soukue.service.common.entity.Result;
import com.soukue.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述
 *
 * @author www.itheima.com
 * @version 1.0
 * @package com.changgou.user.feign *
 * @since 1.0
 */
@FeignClient(name="user")
@RequestMapping("/user")
public interface UserFeign {
    @GetMapping("/load/{username}")
    public Result<User> findByUsername(@PathVariable(name = "username") String username);


    /**
     * 添加积分
     * @param points
     * @param username
     * @return
     */
    @GetMapping(value = "/points/add")
    public Result addPoints(@RequestParam(value = "points") Integer points
            , @RequestParam(value = "username") String username);




}
