package com.jackinjava.tools.jackinjava.sql;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class JackinjavaSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(JackinjavaSqlApplication.class, args);
    }

}
