package com.automationexercise.tests;

import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Contact Us Form")
public class TestCase6 extends TestBasic {

    @Test(description = "Test Case 6: Contact Us Form")
    @Severity(SeverityLevel.MINOR)
    @Story("Contact Us Form")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Contact Us' button
            5. Verify 'GET IN TOUCH' is visible
            6. Enter name, email, subject and message
            7. Upload file
            8. Click 'Submit' button
            9. Click OK button
            10. Verify success message 'Success! Your details have been submitted successfully.' is visible
            11. Click 'Home' button and verify that landed to home page successfully""")
    public void contactUsForm() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyGetInTouchIsVisible();
        verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible();
        clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully();
    }

    @Step("Verify 'GET IN TOUCH' is visible")
    private void verifyGetInTouchIsVisible() {
        String getGetInTouchText = new HomePage(getDriver())
                .contactUsButtonClick()
                .getGetInTouch()
                .getText();
        Assert.assertEquals(getGetInTouchText, "GET IN TOUCH", "Verify 'GET IN TOUCH' is visible");
    }

    @Step("Verify success message 'Success! Your details have been submitted successfully.' is visible")
    private void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
        String alertSuccessText = new ContactUsPage(getDriver())
                .fillForm()
                .submitButtonClick()
                .okButtonClick()
                .getAlertSuccess()
                .getText();
        Assert.assertEquals(alertSuccessText, "Success! Your details have been submitted successfully.", "Verify success message 'Success! Your details have been submitted successfully.' is visible");
    }

    @Step("Click 'Home' button and verify that landed to home page successfully")
    private void clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully() {
        boolean homePageVisible = new ContactUsPage(getDriver())
                .homePageButtonClick()
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(homePageVisible, "Click 'Home' button and verify that landed to home page successfully");
    }
}
