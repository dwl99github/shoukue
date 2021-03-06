package com.soukue.api.goods;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @author soukue
 * @version 1.0
 * @package com.changgou.user.feign *
 * @since 1.0
 */
@FeignClient(name="goods")
@RequestMapping("/goods")
public interface GoodsFeign {

}
