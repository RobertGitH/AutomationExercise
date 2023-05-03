package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Verify")
public class TestCase26 extends TestBasic {

    @Test(description = "Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Verify Scroll Up without 'Arrow' button and Scroll Down functionality")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Scroll down page to bottom
            5. Verify 'SUBSCRIPTION' is visible
            6. Scroll up page to top
            7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen""")
    public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionality() throws InterruptedException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase25.verifySubscriptionIsVisible();
        verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen();
    }

    @Step("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen")
    private void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", new HomePage(getDriver()).getFullFledgedPracticeWebsiteForAutomationEngineers());
        boolean fullFledgedTextIsDisplayed = new HomePage(getDriver()).getFullFledgedPracticeWebsiteForAutomationEngineers().isDisplayed();
        Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        double value = (double) js.executeScript("return window.pageYOffset;");
        Assert.assertTrue(value < 400, "Verify that page is scrolled up");
    }
}
