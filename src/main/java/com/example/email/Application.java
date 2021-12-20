package com.example.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static final String COMPANY_EMAIL = "proba_spring_email@op.pl";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
