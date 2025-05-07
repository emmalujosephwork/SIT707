package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "web")
public class MyServer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MyServer.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MyServer.class, args);
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        // Change the port to 8082
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8082);
        return factory;
    }
}
