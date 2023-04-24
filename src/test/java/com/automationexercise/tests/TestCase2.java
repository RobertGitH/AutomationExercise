package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginSignupPage;
import com.automationexercise.utils.PropertiesLoader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Login User")
public class TestCase2 extends TestBasic {
    @Test(description = "Test Case 2: Login User with correct email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login User with correct email and password")
    @Description("1. Launch browser\n" +
            "2. Navigate to url 'http://automationexercise.com'\n" +
            "3. Verify that home page is visible successfully\n" +
            "4. Click on 'Signup / Login' button\n" +
            "5. Verify 'Login to your account' is visible\n" +
            "6. Enter correct email address and password\n" +
            "7. Click 'login' button\n" +
            "8. Verify that 'Logged in as username' is visible")
    public static void loginUserWithCorrectEmailAndPassword() throws IOException {
        String name = PropertiesLoader.loadProperty("correct.name");
        String email = PropertiesLoader.loadProperty("correct.email");
        String password = PropertiesLoader.loadProperty("correct.password");

        TestCase1.verifyThatHomePageIsVisibleSuccessfully();

        verifyLoginToYourAccountIsVisible();

        String username = new LoginSignupPage(getDriver())
                .fillCorrectLogin(email, password)
                .getUsername()
                .getText();
        verifyThatLoggedInAsUsernameIsVisible(username, name);
    }

    @Step("5. Verify 'Login to your account' is visible")
    public static void verifyLoginToYourAccountIsVisible() {
        String loginToYourAccountText = new HomePage(getDriver())
                .signupLoginClick()
                .getLoginToYourAccount()
                .getText();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "5. Verify 'Login to your account' is visible");
    }

    @Step("8. Verify that 'Logged in as username' is visible")
    public static void verifyThatLoggedInAsUsernameIsVisible(String username, String name) {
        Assert.assertEquals(username, name, "8. Verify that 'Logged in as username' is visible");
    }
}
