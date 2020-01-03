package com.example.demoeventsourcing;

import com.example.demoeventsourcing.Repo.TestRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {TestRepo.class})
public class DemoeventsourcingApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoeventsourcingApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(DemoeventsourcingApplication.class);
    }
}
