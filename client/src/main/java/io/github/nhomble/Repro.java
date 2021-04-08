package io.github.nhomble;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.zalando.logbook.spring.LogbookClientHttpRequestInterceptor;

@SpringBootApplication
@Slf4j
public class Repro implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Repro.class, args);
    }

    @Autowired
    private RestTemplateBuilder builder;

    @Autowired
    private LogbookClientHttpRequestInterceptor interceptor;

    @Override
    public void run(String... args) throws Exception {
        RestTemplate restTemplate = builder
                .additionalInterceptors(interceptor)
                .build();
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
        String out = restTemplate.getForObject("http://localhost:8080", String.class);
        log.info("Response body {}", out);
    }
}
