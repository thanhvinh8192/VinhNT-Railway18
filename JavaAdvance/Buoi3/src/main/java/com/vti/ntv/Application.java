package com.vti.ntv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("Demo API and Spring MVC");
        SpringApplication.run(Application.class, args);
    }
}
