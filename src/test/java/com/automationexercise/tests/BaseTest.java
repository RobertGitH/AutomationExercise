package com.automationexercise.tests;

import com.automationexercise.utils.BrowserManager;
import com.automationexercise.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @BeforeMethod
    public void setup() throws IOException {
        String url = PropertiesLoader.loadProperty("url");

        WebDriver driver = BrowserManager.doBrowserSetup();
        threadLocalDriver.set(driver);
        getDriver().get(url);
        //getDriver().manage().window().maximize();
        //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        threadLocalDriver.remove();
    }
}
