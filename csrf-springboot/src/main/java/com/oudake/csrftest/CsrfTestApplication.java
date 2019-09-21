package com.oudake.csrftest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CsrfTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsrfTestApplication.class, args);
    }

}
