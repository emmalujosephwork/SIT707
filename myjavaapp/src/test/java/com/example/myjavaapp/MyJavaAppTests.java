package com.example.myjavaapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyJavaAppTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        // Basic context load test
    }

    @Test
    void homeReturnsExpectedMessage() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("Hello from Spring Boot!");
        assertThat(body).contains("<h1>");
    }

    @Test
    void homeReturnsHttpStatusOk() {
        var response = this.restTemplate.getForEntity("/", String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    // This test is intentionally designed to fail
    @Test
    void homeReturnsUnexpectedMessage() {
        String body = this.restTemplate.getForObject("/", String.class);
        assertThat(body).contains("This message will never appear");
    }
}
