package com.clear.ocean;

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
@MapperScan("com.clear.ocean.mapper")
public class OceanApplication {

    public static void main(String[] args) {
        SpringApplication.run(OceanApplication.class, args);
    }
}
