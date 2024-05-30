package com.example.campusoverflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CampusOverflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusOverflowApplication.class, args);
    }

}
