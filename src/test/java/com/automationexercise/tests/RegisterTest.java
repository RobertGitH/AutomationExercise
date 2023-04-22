package com.automationexercise.tests;

import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.AccountDeletedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.HomePageLogged;
import com.automationexercise.utils.Util;
import io.qameta.allure.*;
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
                .signupLoginClick()
                .getNewUserSignup()
                .getText();

        verifyNewUserSignupIsVisible(newUserSignupText);
    }

    @Step("5. Verify 'New User Signup!' is visible")
    private void verifyNewUserSignupIsVisible(String newUserSignupText){
        Assert.assertEquals(newUserSignupText, "New User Signup!", "Verify 'New User Signup!' is visible");
    }

    @Story("Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void enterAccountInformationIsVisible() {
        String enterAccountInformationText = new HomePage(getDriver())
                .signupLoginClick()
                .fillSignup("name", "email@o2.pl")
                .getEnterAccountInformation()
                .getText();

        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }

    @Story("Register User")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create and delete account")
    @Description
            (
                    "1. Launch browser\n" +
                            "2. Navigate to url 'http://automationexercise.com'\n" +
                            "3. Verify that home page is visible successfully\n" +
                            "4. Click on 'Signup / Login' button\n" +
                            "5. Verify 'New User Signup!' is visible\n" +
                            "6. Enter name and email address\n" +
                            "7. Click 'Signup' button\n" +
                            "8. Verify that 'ENTER ACCOUNT INFORMATION' is visible\n" +
                            "9. Fill details: Title, Name, Email, Password, Date of birth\n" +
                            "10. Select checkbox 'Sign up for our newsletter!'\n" +
                            "11. Select checkbox 'Receive special offers from our partners!'\n" +
                            "12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number\n" +
                            "13. Click 'Create Account button'\n" +
                            "14. Verify that 'ACCOUNT CREATED!' is visible\n" +
                            "15. Click 'Continue' button\n" +
                            "16. Verify that 'Logged in as username' is visible\n" +
                            "17. Click 'Delete Account' button\n" +
                            "18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button"
            )
    public void accountCreateDelete() {
        String name = "name" + Util.generateCurrentDateAndTime();
        String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

        String accountCreatedText = new HomePage(getDriver())
                .signupLoginClick()
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
