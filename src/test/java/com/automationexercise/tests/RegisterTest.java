package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.Util;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Story("Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that home page is visible successfully")
    public void homePageVisibleSuccessfully() {
        boolean homePageVisible = new HomePage(getDriver())
                .homePageVisible()
                .isDisplayed();

        Assert.assertEquals(homePageVisible, true, "Verify that home page is visible successfully");
    }

    @Story("Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify 'New User Signup!' is visible")
    public void newUserSignupIsVisible() {
        String newUserSignupText = new HomePage(getDriver())
                .openLoginSignupPage()
                .getNewUserSignup()
                .getText();

        Assert.assertEquals(newUserSignupText, "New User Signup!", "Verify 'New User Signup!' is visible");
    }

    @Story("Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void enterAccountInformationIsVisible() {
        String enterAccountInformationText = new HomePage(getDriver())
                .openLoginSignupPage()
                .fillSignup("name" + Util.generateCurrentDateAndTime(), "email" + Util.generateCurrentDateAndTime() + "@o2.pl")
                .getEnterAccountInformation()
                .getText();

        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }

    @Story("Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that 'ACCOUNT CREATED!' is visible")
    public void accountCreatedIsVisible() {
        new HomePage(getDriver()).openLoginSignupPage().fillSignup("name" + Util.generateCurrentDateAndTime(), "email" + Util.generateCurrentDateAndTime() + "@o2.pl");
    }
}
