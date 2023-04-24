package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginSignupPage;
import com.automationexercise.utils.Util;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Login User")
public class TestCase3 extends TestBasic {
    @Test(description = "Test Case 3: Login User with incorrect email and password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login User with incorrect email and password")
    @Description("1. Launch browser\n" +
            "2. Navigate to url 'http://automationexercise.com'\n" +
            "3. Verify that home page is visible successfully\n" +
            "4. Click on 'Signup / Login' button\n" +
            "5. Verify 'Login to your account' is visible\n" +
            "6. Enter incorrect email address and password\n" +
            "7. Click 'login' button\n" +
            "8. Verify error 'Your email or password is incorrect!' is visible")
    public void loginUserWithIncorrectEmailAndPassword() {
        String email = "email" + Util.generateCurrentDateAndTime() + "@incorrect.pl";
        String password = "pass" + Util.generateCurrentDateAndTime();

        boolean homePageVisible = new HomePage(getDriver())
                .homePageIsVisible()
                .isDisplayed();
        TestCase1.verifyThatHomePageIsVisibleSuccessfully(homePageVisible);

        String loginToYourAccountText = new HomePage(getDriver())
                .signupLoginClick()
                .getLoginToYourAccount()
                .getText();
        TestCase2.verifyLoginToYourAccountIsVisible(loginToYourAccountText);

        String errorLoginText = new LoginSignupPage(getDriver())
                .fillIncorrectLogin(email, password).getErrorLogin().getText();
        verifyErrorYourEmailOrPasswordIsIncorrectIsVisible(errorLoginText);
    }

    @Step("8. Verify error 'Your email or password is incorrect!' is visible")
    private void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible(String errorLoginText) {
        Assert.assertEquals(errorLoginText, "Your email or password is incorrect!", "8. Verify error 'Your email or password is incorrect!' is visible");
    }
}
