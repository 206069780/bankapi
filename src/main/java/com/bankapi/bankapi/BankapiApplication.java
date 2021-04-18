package com.bankapi.bankapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.bankapi.bankapi.dao")
public class BankapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankapiApplication.class, args);
    }

}
