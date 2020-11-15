package com.shoukue.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author dengwenlong
 * 2020/11/15
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.shoukue.goods","com.shoukue.service.common"})
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
