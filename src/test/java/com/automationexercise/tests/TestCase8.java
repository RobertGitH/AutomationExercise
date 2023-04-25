package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductsPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Verify")
public class TestCase8 extends TestBasic {

    @Test(description = "Test Case 8: Verify All Products and product detail page")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Verify All Products and product detail page")
    @Description("1. Launch browser\n" +
            "2. Navigate to url 'http://automationexercise.com'\n" +
            "3. Verify that home page is visible successfully\n" +
            "4. Click on 'Products' button\n" +
            "5. Verify user is navigated to ALL PRODUCTS page successfully\n" +
            "6. The products list is visible\n" +
            "7. Click on 'View Product' of first product\n" +
            "8. User is landed to product detail page\n" +
            "9. Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verifyAllProductsAndProductDetailPage() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyUserIsNavigatedToAllProductsPageSuccessfully();
        new ProductsPage(getDriver()).viewProductOfFirstProductButtonClick();
        verifyThatDetailDetailIsVisible();
    }

    @Step("5. Verify user is navigated to ALL PRODUCTS page successfully")
    public static void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
        String allProductsText = new HomePage(getDriver())
                .productsButtonClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(allProductsText, "ALL PRODUCTS", "5. Verify user is navigated to ALL PRODUCTS page successfully");
    }

    @Step("9. Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    private void verifyThatDetailDetailIsVisible() {
        boolean name = new ProductDetailPage(getDriver()).getProductName().isDisplayed();
        boolean category = new ProductDetailPage(getDriver()).getProductCategory().isDisplayed();
        boolean price = new ProductDetailPage(getDriver()).getProductPrice().isDisplayed();
        boolean availability = new ProductDetailPage(getDriver()).getProductAvailability().isDisplayed();
        boolean condition = new ProductDetailPage(getDriver()).getProductCondition().isDisplayed();
        boolean brand = new ProductDetailPage(getDriver()).getProductBrand().isDisplayed();

        Assert.assertTrue(name, "9. Verify that detail detail is visible: name");
        Assert.assertTrue(category, "9. Verify that detail detail is visible: category");
        Assert.assertTrue(price, "9. Verify that detail detail is visible: price");
        Assert.assertTrue(availability, "9. Verify that detail detail is visible: availability");
        Assert.assertTrue(condition, "9. Verify that detail detail is visible: condition");
        Assert.assertTrue(brand, "9. Verify that detail detail is visible: brand");
    }
}
