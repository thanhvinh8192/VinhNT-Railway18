package com.ntv;

import com.ntv.entity.Group;
import com.ntv.repository.GroupRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class Program {
    public static void main(String[] args) {
        System.out.println("Demo CRUD");
        SpringApplication.run(Program.class, args);

    }
}
