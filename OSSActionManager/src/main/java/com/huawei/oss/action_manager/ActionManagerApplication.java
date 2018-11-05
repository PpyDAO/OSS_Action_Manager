package com.huawei.oss.action_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.huawei.oss.action_manager.dao")
@ComponentScan("com.huawei.oss.action_manager")
public class ActionManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActionManagerApplication.class, args);
    }
}
