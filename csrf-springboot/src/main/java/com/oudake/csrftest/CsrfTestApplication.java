package com.oudake.csrftest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableWebSecurity
@MapperScan(basePackages = {"com.oudake.csrftest.dao"})
public class CsrfTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsrfTestApplication.class, args);
    }

}
