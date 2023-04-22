package com.automationexercise.tests;

import com.automationexercise.pages.*;
import com.automationexercise.utils.Util;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Register User")
public class TestCase1 extends TestBasic {
    @Test(description = "Test Case 1: Register User")
    @Severity(SeverityLevel.CRITICAL)
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
    @Story("Register User")
    public void registerUser() {
        String name = "name" + Util.generateCurrentDateAndTime();
        String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

        boolean homePageVisible = new HomePage(getDriver())
                .homePageIsVisible()
                .isDisplayed();
        verifyThatHomePageIsVisibleSuccessfully(homePageVisible);

        String newUserSignupText = new HomePage(getDriver())
                .signupLoginClick()
                .getNewUserSignup()
                .getText();
        verifyNewUserSignupIsVisible(newUserSignupText);

        String enterAccountInformationText = new LoginSignupPage(getDriver())
                .fillSignup(name, email)
                .getEnterAccountInformation()
                .getText();
        verifyThatEnterAccountInformationIsVisible(enterAccountInformationText);

        String accountCreatedText = new EnterAccountInformationPage(getDriver())
                .fillAccountDetails("password", "30", "4", "1996", "Robert", "Rozwadowski", "Robert", "1134 Columbia Road",
                        "Poland", "United States", "Texas", "Dallas", "98607", "111222333")
                .getAccountCreated()
                .getText();
        verifyThatAccountCreatedIsVisible(accountCreatedText);

        String username = new AccountCreatedPage(getDriver())
                .continueButtonClick()
                .getUsername()
                .getText();
        verifyThatLoggedInAsUsernameIsVisible(username, name);

        String accountDeletedText = new HomePageLogged(getDriver())
                .deleteAccountButtonClick()
                .getAccountDeleted()
                .getText();
        verifyThatAccountDeletedIsVisibleAndClickContinueButton(accountDeletedText);
    }

    @Step("3. Verify that home page is visible successfully")
    private void verifyThatHomePageIsVisibleSuccessfully(boolean homePageVisible) {
        Assert.assertTrue(homePageVisible, "3. Verify that home page is visible successfully");
    }

    @Step("5. Verify 'New User Signup!' is visible")
    private void verifyNewUserSignupIsVisible(String newUserSignupText) {
        Assert.assertEquals(newUserSignupText, "New User Signup!", "5. Verify 'New User Signup!' is visible");
    }

    @Step("8. Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    private void verifyThatEnterAccountInformationIsVisible(String enterAccountInformationText) {
        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "8. Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }

    @Step("14. Verify that 'ACCOUNT CREATED!' is visible")
    private void verifyThatAccountCreatedIsVisible(String accountCreatedText) {
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "14. Verify that 'ACCOUNT CREATED!' is visible");
    }

    @Step("16. Verify that 'Logged in as username' is visible")
    private void verifyThatLoggedInAsUsernameIsVisible(String username, String name) {
        Assert.assertEquals(username, name, "16. Verify that 'Logged in as username' is visible");
    }

    @Step("18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button")
    private void verifyThatAccountDeletedIsVisibleAndClickContinueButton(String accountDeletedText) {
        Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible");
        new AccountDeletedPage(getDriver()).continueButtonClick();
    }
}
