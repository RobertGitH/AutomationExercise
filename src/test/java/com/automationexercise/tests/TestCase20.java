package com.automationexercise.tests;

import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.JSONReader;
import io.qameta.allure.*;
import org.jetbrains.annotations.NotNull;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Search")
public class TestCase20 extends TestBasic {

    @Test(description = "Test Case 20: Search Products and Verify Cart After Login")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Products and Verify Cart After Login")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify user is navigated to ALL PRODUCTS page successfully
            5. Enter product name in search input and click search button
            6. Verify 'SEARCHED PRODUCTS' is visible
            7. Verify all the products related to search are visible
            8. Add those products to cart
            9. Click 'Cart' button and verify that products are visible in cart
            10. Click 'Signup / Login' button and submit login details
            11. Again, go to Cart page
            12. Verify that those products are visible in cart after login as well
            13. Remove all products that have been added
            14. Verify 'Cart is empty! Click here to buy products.' is visible""")
    public void searchProductsAndVerifyCartAfterLogin() throws IOException, ParseException, InterruptedException {
        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        TestCase9.verifySearchedProductsIsVisible();
        List<String> productsNames = TestCase9.verifyAllTheProductsRelatedToSearchAreVisible();
        new ProductsPage(getDriver()).addAllProducts();
        clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
        new HomePage(getDriver())
                .signupLoginClick()
                .fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
        verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell(productsNames);
        verifyThatCartIsEmpty();
    }

    @Step("Click 'Cart' button and verify that products are visible in cart")
    private void clickCartButtonAndVerifyThatProductsAreVisibleInCart(@NotNull List<String> productsNames) {
        List<String> productsNamesAdded = new HomePage(getDriver())
                .cartButtonClick()
                .getProductsNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), productsNamesAdded.get(i), "Verify that products are visible in cart");
            System.out.println("Search: " + productsNames.get(i) + " = Added: " + productsNamesAdded.get(i));
        }
    }

    @Step("Verify that those products are visible in cart after login as well")
    private void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell(@NotNull List<String> productsNames) {
        clickCartButtonAndVerifyThatProductsAreVisibleInCart(productsNames);
    }

    @Step("Verify 'Cart is empty! Click here to buy products.' is visible")
    private void verifyThatCartIsEmpty() throws InterruptedException {
        String emptyCartText = new CartPage(getDriver())
                .deleteAllAddedProducts()
                .getEmptyCartSpan()
                .getText();
        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify 'Cart is empty! Click here to buy products.' is visible");
    }
}
