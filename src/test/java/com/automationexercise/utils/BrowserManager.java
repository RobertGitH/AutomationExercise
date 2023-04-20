package com.automationexercise.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class BrowserManager {

    public static WebDriver doBrowserSetup() throws IOException {

        WebDriver driver = null;
        String name = PropertiesLoader.loadProperty("browser.name");
        if (name.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headed"); //add options for --headed or --headless browser launch
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);

            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));

        } else if (name.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("-headed");
            firefoxOptions.addArguments("-private");
            driver = new FirefoxDriver(firefoxOptions);
        }
        return driver;
    }
}
