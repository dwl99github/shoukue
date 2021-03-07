package com.soukue.order.service;

import com.soukue.pojo.greenyep.reqest.CreateOrderReq;
import com.soukue.pojo.order.Order;

/**
 * User业务层接口
 * @author soukue
 * 2020/11/15
 */
public interface OrderService {
    Order findById(String id);

    Integer createOrder(CreateOrderReq createOrderReq);
}
