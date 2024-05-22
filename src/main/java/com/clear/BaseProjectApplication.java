package com.clear;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 *
 * @author qml
 * @date 2024-5-22 14:19
 * @return
 **/
@SpringBootApplication
@MapperScan("com.clear.mapper")
public class BaseProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseProjectApplication.class, args);
    }
}
