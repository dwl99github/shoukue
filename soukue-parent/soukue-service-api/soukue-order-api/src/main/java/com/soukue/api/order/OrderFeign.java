package com.soukue.api.goods;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author soukue
 */
@FeignClient(name="order")
@RequestMapping("/order")
public interface OrderFeign {

}
