package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Verify")
public class TestCase11 extends TestBasic {

    @Test(description = "Test Case 11: Verify Subscription in Cart page")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Verify Subscription in Cart page")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'Cart' button and scroll down to footer
            5. Verify text 'SUBSCRIPTION'
            6. Enter email address in input and click arrow button
            7. Verify success message 'You have been successfully subscribed!' is visible""")
    public void verifySubscriptionInCartPage() throws IOException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        new HomePage(getDriver()).cartButtonClick();
        TestCase10.verifyTextSubscription();
        TestCase10.verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
    }
}
