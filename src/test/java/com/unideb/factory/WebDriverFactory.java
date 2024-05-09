package com.unideb.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Objects;

@Component
public class WebDriverFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger((WebDriverFactory.class));

    @Value("${headless:true}")
    private Boolean headless;

    public static WebDriver webDriver;

    public WebDriver getInstance() {
        if (webDriver == null) {
            webDriver = setUpChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return webDriver;
    }

    private WebDriver setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        var options = new ChromeOptions()
                .addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage");
        options = headless ? options.addArguments("--headless=new") : options;
        LOGGER.info("ChromeDriver was created");
        return new ChromeDriver(options);
    }

    public void closeWebDriver() {
        if (Objects.nonNull(webDriver)) {
            webDriver.close();
            webDriver.quit();
            webDriver = null;
            LOGGER.info("WebDriver has been closed");
        }
    }
}

