package org.zerock.tododemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TododemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TododemoApplication.class, args);
    }

}
