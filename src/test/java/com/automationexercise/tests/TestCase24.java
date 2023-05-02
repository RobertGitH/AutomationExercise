package com.automationexercise.tests;

import com.automationexercise.pages.PaymentPage;
import com.automationexercise.utils.Util;
import com.automationexercise.utils.VerifyDownload;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Invoice")
public class TestCase24 extends TestBasic {

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

    @Test(description = "Test Case 24: Download Invoice after purchase order")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Download Invoice after purchase order")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Add products to cart
            5. Click 'Cart' button
            6. Verify that cart page is displayed
            7. Click Proceed To Checkout
            8. Click 'Register / Login' button
            9. Fill all details in Signup and create account
            10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            11. Verify ' Logged in as username' at top
            12. Click 'Cart' button
            13. Click 'Proceed To Checkout' button
            14. Verify Address Details and Review Your Order
            15. Enter description in comment text area and click 'Place Order'
            16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            17. Click 'Pay and Confirm Order' button
            18. Verify success message 'Your order has been placed successfully!'
            19. Click 'Download Invoice' button and verify invoice is downloaded successfully
            20. Click 'Continue' button
            21. Click 'Delete Account' button
            22. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
    public void downloadInvoiceAfterPurchaseOrder() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase14.verifyThatCartPageIsDisplayed();
        TestCase14.verifyAccountCreatedAndClickContinueButton(name, email);
        TestCase14.verifyLoggedInAsUsernameAtTop(name);
        TestCase14.verifyAddressDetailsAndReviewYourOrder();
        TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
        clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully();
        new PaymentPage(getDriver()).continueButtonClick();
        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }

    @Step("Click 'Download Invoice' button and verify invoice is downloaded successfully")
    private void clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() throws IOException {
        new PaymentPage(getDriver()).downloadInvoiceButtonClick();
        boolean isFileDownloaded = VerifyDownload.isFileDownloaded("invoice", "txt", 5000);
        Assert.assertTrue(isFileDownloaded, "Verify invoice is downloaded successfully.");
    }
}
