package com.github.lizeze.generationtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.lizeze.**.mapper")
public class GenerationToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerationToolApplication.class, args);
    }

}
