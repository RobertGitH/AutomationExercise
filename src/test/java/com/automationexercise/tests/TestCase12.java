package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Regression Tests")
@Feature("Cart")
public class TestCase12 extends TestBasic {

    @Test(description = "Test Case 12: Add Products in Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add Products in Cart")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click 'Products' button
            5. Hover over first product and click 'Add to cart'
            6. Click 'Continue Shopping' button
            7. Hover over second product and click 'Add to cart'
            8. Click 'View Cart' button
            9. Verify both products are added to Cart
            10. Verify their prices, quantity and total price""")
    public void addProductsInCart() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyBothProductsAreAddedToCart();
        verifyTheirPricesQuantityAndTotalPrice();
    }

    @Step("9. Verify both products are added to Cart")
    private void verifyBothProductsAreAddedToCart() {
        List<String> productNames = new HomePage(getDriver())
                .productsButtonClick()
                .addProductsToCart()
                .getProductsNames();
        Assert.assertEquals(productNames.size(), 2, "9. Verify both products are added to Cart");
    }

    @Step("10. Verify their prices, quantity and total price")
    private void verifyTheirPricesQuantityAndTotalPrice() {
        List<String> prices = new CartPage(getDriver()).getPrices();
        List<String> quantity = new CartPage(getDriver()).getQuantity();
        List<String> totalPrices = new CartPage(getDriver()).getTotalPrices();

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(totalPrices.get(i), prices.get(i), "10. Verify their prices and total price");
            Assert.assertEquals(quantity.get(i), "1", "10. Verify their quantity");
            System.out.println(i + ". Prices = Total Prices | " + prices.get(i) + " = " + totalPrices.get(i));
            System.out.println(i + ". Quantity = 1 | " + quantity.get(i).equals("1"));
        }
    }
}
