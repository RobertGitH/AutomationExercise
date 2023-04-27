package com.automationexercise.tests;

import com.automationexercise.pages.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Place Order")
public class TestCase14 extends TestBasic {

    @Test(description = "Test Case 14: Place Order: Register while Checkout")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Place Order: Register while Checkout")
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
            19. Click 'Delete Account' button
            20. Verify 'ACCOUNT DELETED!' and click 'Continue' button""")
    public void placeOrderRegisterWhileCheckout() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyThatCartPageIsDisplayed();
        verifyAccountCreatedAndClickContinueButton();
        verifyLoggedInAsUsernameAtTop();
        new HomePage(getDriver()).cartButtonClick().proceedToCheckoutButtonClick();
    }

    @Step("6. Verify that cart page is displayed")
    private void verifyThatCartPageIsDisplayed() {
        String shoppingCartText = new ProductsPage(getDriver())
                .addProductsToCart()
                .getShoppingCart()
                .getText();
        Assert.assertEquals(shoppingCartText, "Shopping Cart", "6. Verify that cart page is displayed");
    }

    @Step("10. Verify 'ACCOUNT CREATED!' and click 'Continue' button")
    private void verifyAccountCreatedAndClickContinueButton() {
        String accountCreatedText = new CartPage(getDriver())
                .proceedToCheckoutButtonClick()
                .registerLoginButtonClick()
                .fillCorrectSignup()
                .fillAccountDetails()
                .getAccountCreated()
                .getText();

        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "10. Verify 'ACCOUNT CREATED!'");
        new AccountCreatedPage(getDriver()).continueButtonClick();
    }

    @Step("11. Verify ' Logged in as username' at top")
    private void verifyLoggedInAsUsernameAtTop() {
        String username = new LoggedHomePage(getDriver())
                .getUsername()
                .getText();
        Assert.assertEquals(username, name, "11. Verify ' Logged in as username' at top");
    }
}
