package com.shoukue.goods.service;

import com.shoukue.goods.pojo.Goods;

/**
 * User业务层接口
 * @author dengwenlong
 * 2020/11/15
 */
public interface GoodsService {
    Goods findById(String id);
}
