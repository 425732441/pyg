package com.zhl.pygmanagerweb;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"com.zhl.pyg.**.controller","com.zhl.pygmanagerweb"})
@EnableDubbo
public class PygManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PygManagerWebApplication.class, args);
    }

}
