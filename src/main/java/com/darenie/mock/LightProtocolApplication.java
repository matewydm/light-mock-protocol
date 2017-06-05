package com.darenie.mock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class LightProtocolApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightProtocolApplication.class, args);
    }
}
