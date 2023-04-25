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
    @Story("Create and delete account")
    @Description("1. Launch browser\n" +
            "2. Navigate to url 'http://automationexercise.com'\n" +
            "3. Verify that home page is visible successfully\n" +
            "4. Click on 'Contact Us' button\n" +
            "5. Verify 'GET IN TOUCH' is visible\n" +
            "6. Enter name, email, subject and message\n" +
            "7. Upload file\n" +
            "8. Click 'Submit' button\n" +
            "9. Click OK button\n" +
            "10. Verify success message 'Success! Your details have been submitted successfully.' is visible\n" +
            "11. Click 'Home' button and verify that landed to home page successfully")
    public void contactUsForm() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyGetInTouchIsVisible();
        verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible();
        clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully();
    }

    @Step("5. Verify 'GET IN TOUCH' is visible")
    private void verifyGetInTouchIsVisible() {
        String getGetInTouchText = new HomePage(getDriver())
                .contactUsButtonClick()
                .getGetInTouch()
                .getText();
        Assert.assertEquals(getGetInTouchText, "GET IN TOUCH", "5. Verify 'GET IN TOUCH' is visible");
    }

    @Step("10. Verify success message 'Success! Your details have been submitted successfully.' is visible")
    private void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
        String alertSuccessText = new ContactUsPage(getDriver())
                .fillForm()
                .submitButtonClick()
                .okButtonClick()
                .getAlertSuccess()
                .getText();
        Assert.assertEquals(alertSuccessText, "Success! Your details have been submitted successfully.", "10. Verify success message 'Success! Your details have been submitted successfully.' is visible");
    }

    @Step("11. Click 'Home' button and verify that landed to home page successfully")
    private void clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully() {
        boolean homePageVisible = new ContactUsPage(getDriver())
                .homePageButtonClick()
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(homePageVisible, "11. Click 'Home' button and verify that landed to home page successfully");
    }
}
