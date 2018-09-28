package com.jlh.demoworkweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScans({@ComponentScan("com.jlh.demowork.core.config")})
@MapperScan("com.jlh.demoworkweb.mapper")
@SpringBootApplication
public class DemoworkWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoworkWebApplication.class, args);
    }
}
