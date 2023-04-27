package com.automationexercise.tests;

import com.automationexercise.utils.BrowserManager;
import com.automationexercise.utils.PropertiesLoader;
import com.automationexercise.utils.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestBasic {

    //test data
    public String name = "name" + Util.generateCurrentDateAndTime();
    public String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";
    public static String correctName = "robert212197331002"; //created account name
    public static String correctEmail = "robert212197331002@test.pl"; //created account email
    public static String correctPassword = "robert212197331002@test.pl"; //created account password
    public String firstName = "Robert";
    public String lastName = "Rozwadowski";
    public String password = "pass" + Util.generateCurrentDateAndTime();
    public String day = "30";
    public String month = "4";
    public String year = "1996";
    public String company = "Pierogi";
    public String address1 = "1134 Columbia Road";
    public String address2 = "Columbia";
    public String country = "United States";
    public String state = "Texas";
    public String city = "Dallas";
    public String zipcode = "98607";
    public String mobileNumber = "111222333";

    protected static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    @BeforeMethod
    public void setup() throws IOException {
        String url = PropertiesLoader.loadProperty("url");

        WebDriver driver = BrowserManager.doBrowserSetup();
        tdriver.set(driver);
        getDriver().get(url);
        //getDriver().manage().window().maximize();
        //getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
    }

    @AfterMethod
    public void tearDown() {
        //getDriver().quit();
        tdriver.remove();
    }
}
