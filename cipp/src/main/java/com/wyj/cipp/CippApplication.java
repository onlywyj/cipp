package com.wyj.cipp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.wyj.cipp.dao")
public class CippApplication {

    public static void main(String[] args) {
        SpringApplication.run(CippApplication.class, args);
    }

}
