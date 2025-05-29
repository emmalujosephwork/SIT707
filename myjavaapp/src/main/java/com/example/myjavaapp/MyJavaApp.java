package com.example.myjavaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MyJavaApp {

    public static void main(String[] args) {
        SpringApplication.run(MyJavaApp.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "<html>" +
               "<head><title>Welcome User</title></head>" +
               "<body style='font-family:Arial, sans-serif; text-align:center; margin-top:50px;'>" +
               "<h1>Hello from Spring Boot!</h1>" +
               "<p>Welcome User to my simple web app.</p>" +
               "</body>" +
               "</html>";
    }
}
