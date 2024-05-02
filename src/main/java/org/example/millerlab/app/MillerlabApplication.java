package org.example.millerlab.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackages = "org.example")
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"org.example"})
@EnableJpaRepositories(basePackages = {"org.example"})
public class MillerlabApplication {

    public static void main(String[] args) {
        SpringApplication.run(MillerlabApplication.class, args);
    }

}
