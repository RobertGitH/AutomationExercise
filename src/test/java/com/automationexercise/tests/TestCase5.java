package com.automationexercise.tests;

import com.automationexercise.pages.LoginSignupPage;
import com.automationexercise.utils.PropertiesLoader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Register User")
public class TestCase5 extends TestBasic {

    @Test(description = "Test Case 5: Register User with existing email")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User with existing email")
    @Description("1. Launch browser\n" +
            "2. Navigate to url 'http://automationexercise.com'\n" +
            "3. Verify that home page is visible successfully\n" +
            "4. Click on 'Signup / Login' button\n" +
            "5. Verify 'New User Signup!' is visible\n" +
            "6. Enter name and already registered email address\n" +
            "7. Click 'Signup' button\n" +
            "8. Verify error 'Email Address already exist!' is visible")
    public void registerUserWithExistingEmail() throws IOException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase1.verifyNewUserSignupIsVisible();
        verifyErrorEmailAddressAlreadyExistIsVisible();
    }

    @Step("8. Verify error 'Email Address already exist!' is visible")
    private void verifyErrorEmailAddressAlreadyExistIsVisible() throws IOException {
        String name = PropertiesLoader.loadProperty("correct.name");
        String email = PropertiesLoader.loadProperty("correct.email");

        String emailAddressAlreadyExistText = new LoginSignupPage(getDriver())
                .fillIncorrectSignup(name, email)
                .getEmailAddressAlreadyExist()
                .getText();
        Assert.assertEquals(emailAddressAlreadyExistText, "Email Address already exist!", "8. Verify error 'Email Address already exist!' is visible");
    }
}
