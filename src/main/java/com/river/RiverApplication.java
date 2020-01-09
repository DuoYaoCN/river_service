package com.river;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.river.persistence")
public class RiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiverApplication.class, args);
    }

}
