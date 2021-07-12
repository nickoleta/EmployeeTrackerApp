package com.spring.boot.preparation;

import com.spring.boot.preparation.dao.EmployeesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @SpringBootApplication = @SpringBootConfiguration + @ComponentScan + @EnableAutoConfiguration
 */
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = EmployeesRepository.class)
public class SpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class);
    }
}
