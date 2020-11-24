package com.soukue.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dengwenlong
 * 2020/11/15
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.soukue.goods","com.soukue.service.common"})
@EnableFeignClients(basePackages = {"com.soukue.user.feign"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
