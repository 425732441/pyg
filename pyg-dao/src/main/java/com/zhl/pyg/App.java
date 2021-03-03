package com.zhl.pyg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zhanghualei
 * @Classname App
 * @Date 2021/3/3 10:07
 */
@SpringBootApplication(scanBasePackages = {
    "com.zhl.pyg.**"
})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
