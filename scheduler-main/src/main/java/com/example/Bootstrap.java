package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.infra.dao")
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Bootstrap.class, args);
    }
}
