package com.unideb.config;

import com.unideb.factory.WebDriverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.unideb")
public class TestConfig {
    @Bean(destroyMethod = "closeWebDriver")
    public WebDriverFactory webDriverFactory() {
        return new WebDriverFactory();
    }

}
