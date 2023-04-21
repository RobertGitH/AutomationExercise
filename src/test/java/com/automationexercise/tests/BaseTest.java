package com.automationexercise.tests;

import com.automationexercise.utils.Allure;
import com.automationexercise.utils.BrowserManager;
import com.automationexercise.utils.PropertiesLoader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @BeforeSuite
    public void deleteReport() throws IOException {
        FileUtils.deleteDirectory(new File("target/allure-results"));
    }

    @AfterSuite
    public void generateReport() {
        Allure.onGenerateAllureReport();
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
        //getDriver().quit();
        threadLocalDriver.remove();
    }
}
