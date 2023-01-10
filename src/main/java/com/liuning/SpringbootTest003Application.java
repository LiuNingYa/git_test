package com.liuning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.liuning.mapper")
@SpringBootApplication
public class SpringbootTest003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTest003Application.class, args);
    }

}
