package io.github.nhomble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequestMapping
@RestController
public class Srv {

    public static void main(String[] args) {
        SpringApplication.run(Srv.class, args);
    }

    @GetMapping
    String hello() {
        return "hello";
    }
}
