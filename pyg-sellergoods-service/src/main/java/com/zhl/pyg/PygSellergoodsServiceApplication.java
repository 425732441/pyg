package com.zhl.pyg;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
@MapperScan(basePackages = "com.zhl.**.dao.**")//扫描mapper接口
public class PygSellergoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PygSellergoodsServiceApplication.class, args);
    }

}
