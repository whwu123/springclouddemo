package com.wch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wch.mapper")
public class NacosSeverApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosSeverApp.class, args);
    }
}
