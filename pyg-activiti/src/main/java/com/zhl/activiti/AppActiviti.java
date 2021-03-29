package com.zhl.activiti;

// import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Zhanghualei
 * @Classname App
 * @Date 2021/3/6 12:21
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AppActiviti {
    public static void main(String[] args) {
        SpringApplication.run(AppActiviti.class,args);
    }
}
