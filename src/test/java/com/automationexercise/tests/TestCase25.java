package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Verify")
public class TestCase25 extends TestBasic {

    @Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Scroll down page to bottom
            5. Verify 'SUBSCRIPTION' is visible
            6. Click on arrow at bottom right side to move upward
            7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen""")
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifySubscriptionIsVisible();
        verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen();
    }

    @Step("Verify 'SUBSCRIPTION' is visible")
    private void verifySubscriptionIsVisible() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", new HomePage(getDriver()).getSubscription());
        boolean subscriptionIsDisplayed = new HomePage(getDriver()).getSubscription().isDisplayed();
        Assert.assertTrue(subscriptionIsDisplayed, "Verify 'SUBSCRIPTION' is visible");
    }

    @Step("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen")
    private void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        boolean fullFledgedTextIsDisplayed = new HomePage(getDriver())
                .scrollUpButtonClick()
                .getFullFledgedPracticeWebsiteForAutomationEngineers()
                .isDisplayed();
        Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        double value = (double) js.executeScript("return window.pageYOffset;");
        Assert.assertTrue(value < 3000, "Verify that page is scrolled up");
    }
}
