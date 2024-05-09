package com.unideb.config;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = TestConfig.class)
@CucumberOptions(glue = "com.unideb")
public class CucumberSpringConfiguration {
}
