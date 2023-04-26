package com.automationexercise.tests;

import com.automationexercise.pages.LoggedHomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Logout User")
public class TestCase4 extends TestBasic {

    @Test(description = "Test Case 4: Logout User")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Logout User")
    @Description("1. Launch browser\n" +
            "2. Navigate to url 'http://automationexercise.com'\n" +
            "3. Verify that home page is visible successfully\n" +
            "4. Click on 'Signup / Login' button\n" +
            "5. Verify 'Login to your account' is visible\n" +
            "6. Enter correct email address and password\n" +
            "7. Click 'login' button\n" +
            "8. Verify that 'Logged in as username' is visible\n" +
            "9. Click 'Logout' button\n" +
            "10. Verify that user is navigated to login page")
    public void logoutUser() throws IOException {
        TestCase2.loginUserWithCorrectEmailAndPassword();
        verifyThatUserIsNavigatedToLoginPage();
    }

    @Step("10. Verify that user is navigated to login page")
    private void verifyThatUserIsNavigatedToLoginPage() {
        String loginToYourAccountText = new LoggedHomePage(getDriver())
                .logoutButtonClick()
                .getLoginToYourAccount()
                .getText();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "10. Verify that user is navigated to login page");
    }
}
