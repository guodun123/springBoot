package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
@SpringBootApplication(scanBasePackages = {"com.example.demo"})
@MapperScan ("com.example.demo.**.dao")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("" +
                "##############################\n" +
                "#####spring boot 启动成功######\n" +
                "##############################");
    }
}
