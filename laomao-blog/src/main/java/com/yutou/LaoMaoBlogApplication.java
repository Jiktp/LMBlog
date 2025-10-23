package com.yutou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yutou.mapper")
public class LaoMaoBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(LaoMaoBlogApplication.class, args);
    }
}
