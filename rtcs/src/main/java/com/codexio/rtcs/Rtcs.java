package com.codexio.rtcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Rtcs {

    public static void main(String[] args) {
        SpringApplication.run(Rtcs.class, args);
    }
}
