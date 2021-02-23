package com.ktpt.commerssg.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ktpt.commerssg.jpa")
@EntityScan(basePackages = "com.ktpt.commerssg.jpa")
@Configuration
public class JPAConfig {
}
