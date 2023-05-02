package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Regression Tests")
@Feature("Cart")
public class TestCase22 extends TestBasic {
    @Test(description = "Test Case 22: Add to cart from Recommended items")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Add to cart from Recommended items")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Scroll to bottom of page
            4. Verify 'RECOMMENDED ITEMS' are visible
            5. Click on 'Add To Cart' on Recommended product
            6. Click on 'View Cart' button
            7. Verify that product is displayed in cart page""")
    public void AddToCartFromRecommendedItems() {
        verifyRecommendedItemsAreVisible();
        verifyThatProductIsDisplayedInCartPage();
    }

    @Step("Verify 'RECOMMENDED ITEMS' are visible")
    private void verifyRecommendedItemsAreVisible() {
        String recommendedItemsText = new HomePage(getDriver())
                .getRecommendedItems()
                .getText();
        Assert.assertEquals(recommendedItemsText, "RECOMMENDED ITEMS", "Verify 'RECOMMENDED ITEMS' are visible");
    }

    @Step("Verify that product is displayed in cart page")
    private void verifyThatProductIsDisplayedInCartPage() {
        List<String> productsNames = new HomePage(getDriver())
                .blueTopAddToCartButtonClick()
                .viewCartButtonClick()
                .getProductsNames();
        Assert.assertEquals(productsNames.get(0), "Blue Top", "Verify that product is displayed in cart page");
    }
}
