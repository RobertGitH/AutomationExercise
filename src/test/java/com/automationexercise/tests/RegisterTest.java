package com.automationexercise.tests;

import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.AccountDeletedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.HomePageLogged;
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
                .fillSignup("name", "email@o2.pl")
                .getEnterAccountInformation()
                .getText();

        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }

    @Story("Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create and delete account")
    public void accountCreateDelete() {
        String name = "name" + Util.generateCurrentDateAndTime();
        String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

        String accountCreatedText = new HomePage(getDriver())
                .openLoginSignupPage()
                .fillSignup(name, email)
                .fillAccountDetails("password", "30", "4", "1996", "Robert", "Rozwadowski", "Robert", "1134 Columbia Road",
                        "Poland", "United States", "Texas", "Dallas", "98607", "111222333")
                .getAccountCreated()
                .getText();

        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify that 'ACCOUNT CREATED!' is visible");

        String username = new AccountCreatedPage(getDriver())
                .continueButtonClick()
                .getUsername()
                .getText();

        Assert.assertEquals(username, name, "Verify that 'Logged in as username' is visible");

        String accountDeletedText = new HomePageLogged(getDriver())
                .deleteAccountButtonClick()
                .getAccountDeleted()
                .getText();

        Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible");

        new AccountDeletedPage(getDriver()).continueButtonClick();
    }

}
