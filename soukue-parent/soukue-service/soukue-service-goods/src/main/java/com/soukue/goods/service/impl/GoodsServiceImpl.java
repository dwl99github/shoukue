package com.soukue.goods.service.impl;

import com.soukue.goods.pojo.Goods;
import com.soukue.goods.pojo.Spu;
import com.soukue.goods.service.GoodsService;
import com.soukue.service.common.entity.Result;
import com.soukue.user.feign.UserFeign;
import com.soukue.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dengwenlong
 * 2020/11/15
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private UserFeign userFeign;

    @Override
    public Goods findById(String id) {
        Result<User> testUserFeign = userFeign.findByUsername("testUserFeign");
        Goods goods = new Goods();
        Spu spu = new Spu();
        spu.setId(1L);
        spu.setName("滑雪服");
        spu.setName(testUserFeign.getData().getUsername());
        goods.setSpu(spu);
        return goods;
    }
}
