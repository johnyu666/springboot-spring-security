package cn.johnyu.springbootspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringbootSpringSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringSecurityApplication.class, args);
    }
}
