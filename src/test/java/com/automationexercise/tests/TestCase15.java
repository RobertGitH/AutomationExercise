package com.automationexercise.tests;

import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoggedHomePage;
import com.automationexercise.utils.Util;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Regression Tests")
@Feature("Place Order")
public class TestCase15 extends TestBasic {

    String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";

    @Test(description = "Test Case 15: Place Order: Register before Checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: Register before Checkout")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'Signup / Login' button
            5. Fill all details in Signup and create account
            6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            7. Verify ' Logged in as username' at top
            8. Add products to cart
            9. Click 'Cart' button
            10. Verify that cart page is displayed
            11. Click Proceed To Checkout
            12. Verify Address Details and Review Your Order
            13. Enter description in comment text area and click 'Place Order'
            14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            15. Click 'Pay and Confirm Order' button
            16. Verify success message 'Congratulations! Your order has been confirmed!'
            17. Click 'Delete Account' button
            18. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
    public void placeOrderRegisterBeforeCheckout() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyAccountCreatedAndClickContinueButton();
        verifyLoggedInAsUsernameAtTop();
        TestCase14.verifyThatCartPageIsDisplayed();
        new CartPage(getDriver()).proceedToCheckoutButtonClick();
        TestCase14.verifyAddressDetailsAndReviewYourOrder();
        TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }

    @Step("6. Verify 'ACCOUNT CREATED!' and click 'Continue' button")
    private void verifyAccountCreatedAndClickContinueButton() throws IOException, ParseException {
        String accountCreatedText = new HomePage(getDriver())
                .signupLoginClick()
                .fillCorrectSignup(name, email)
                .fillAccountDetails()
                .getAccountCreated()
                .getText();
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "6. Verify 'ACCOUNT CREATED!'");
        new AccountCreatedPage(getDriver()).continueButtonClick();
    }

    @Step("7. Verify ' Logged in as username' at top")
    private void verifyLoggedInAsUsernameAtTop() {
        String username = new LoggedHomePage(getDriver())
                .getUsername()
                .getText();
        Assert.assertEquals(username, name, "7. Verify ' Logged in as username' at top");
    }
}
