package com.ktpt.commerssg.batch.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ktpt.commerssg.*")
@EntityScan(basePackages = "com.ktpt.commerssg.*")
@ComponentScan(basePackages = "com.ktpt.commerssg.*")
@Configuration
public class ScanConfig {
}
