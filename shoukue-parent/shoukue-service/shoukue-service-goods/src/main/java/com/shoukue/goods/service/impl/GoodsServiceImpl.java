package com.shoukue.goods.service.impl;

import com.shoukue.goods.pojo.Goods;
import com.shoukue.goods.pojo.Spu;
import com.shoukue.goods.service.GoodsService;
import org.springframework.stereotype.Service;

/**
 * @author dengwenlong
 * 2020/11/15
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Override
    public Goods findById(String id) {
        Goods goods = new Goods();
        Spu spu = new Spu();
        spu.setId(1L);
        spu.setName("滑雪服");
        goods.setSpu(spu);
        return goods;
    }
}
