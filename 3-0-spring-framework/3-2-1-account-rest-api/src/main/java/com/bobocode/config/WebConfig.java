package com.bobocode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * This class provides web (servlet) related configuration.
 * <p>
 * Configures web-related components and enables Spring MVC.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bobocode.web")
public class WebConfig {
}
