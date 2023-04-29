package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Verify")
public class TestCase7 extends TestBasic {

    @Test(description = "Test Case 7: Verify Test Cases Page")
    @Severity(SeverityLevel.TRIVIAL)
    @Story("Verify Test Cases Page")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Test Cases' button
            5. Verify user is navigated to test cases page successfully""")
    public void verifyTestCasesPage() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyUserIsNavigatedToTestCasesPageSuccessfully();
    }

    @Step("Verify user is navigated to test cases page successfully")
    private void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
        String testCasesText = new HomePage(getDriver())
                .testCasesButtonClick()
                .getTestCases()
                .getText();
        Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");
    }
}
