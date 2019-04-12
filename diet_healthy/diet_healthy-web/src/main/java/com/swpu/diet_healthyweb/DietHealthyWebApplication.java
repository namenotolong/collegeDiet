package com.swpu.diet_healthyweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.swpu.diet_healthydao")
@SpringBootApplication(scanBasePackages = "com.swpu")
public class DietHealthyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DietHealthyWebApplication.class, args);
    }

}
