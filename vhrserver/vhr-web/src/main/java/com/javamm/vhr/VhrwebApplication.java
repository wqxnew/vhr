package com.javamm.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.javamm.vhr.mapper")
public class VhrwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrwebApplication.class, args);
    }

}
