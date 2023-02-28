package kr.taehoon.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"kr.taehoon.exercise.entity"})
@EnableJpaRepositories(basePackages = {"kr.taehoon.exercise.repository"})
@SpringBootApplication(scanBasePackages = "kr.taehoon.exercise")
public class ExerciseApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application, application-core");
        SpringApplication.run(ExerciseApplication.class);
    }
}
