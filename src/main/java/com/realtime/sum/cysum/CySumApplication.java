package com.realtime.sum.cysum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CySumApplication {

    public static void main(String[] args) {
        SpringApplication.run(CySumApplication.class, args);
    }

}
