package com.automationexercise.tests;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.JSONReader;
import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Products")
public class TestCase19 extends TestBasic {

    @Test(description = "Test Case 19: View & Cart Brand Products")
    @Severity(SeverityLevel.CRITICAL)
    @Story("View & Cart Brand Products")
    @Description("""
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Click on 'Products' button
            4. Verify that Brands are visible on left side bar
            5. Click on any brand name
            6. Verify that user is navigated to brand page and brand products are displayed
            7. On left side bar, click on any other brand link
            8. Verify that user is navigated to that brand page and can see products""")
    public void viewCartBrandProducts() throws IOException, ParseException {
        verifyThatBrandsAreVisibleOnLeftSideBar();
        verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed();
        verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts();
    }

    @Step("Verify that Brands are visible on left side bar")
    private void verifyThatBrandsAreVisibleOnLeftSideBar() {
        boolean brandsIsDisplayed = new HomePage(getDriver())
                .productsButtonClick()
                .getBrands()
                .isDisplayed();
        Assert.assertTrue(brandsIsDisplayed, "Verify that Brands are visible on left side bar");
    }

    @Step("Verify that user is navigated to brand page and brand products are displayed")
    private void verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed() throws IOException, ParseException {
        String titleTextCenter = new ProductsPage(getDriver())
                .poloBrandClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "BRAND - POLO PRODUCTS", "Verify that user is navigated to brand page");

        List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), JSONReader.poloBrandProducts(String.valueOf(i)), "Verify that brand products are displayed");
        }
    }

    @Step("Verify that user is navigated to that brand page and can see products")
    private void verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts() throws IOException, ParseException {
        String titleTextCenter = new ProductsPage(getDriver())
                .madameBrandClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "BRAND - MADAME PRODUCTS", "Verify that user is navigated to that brand page");

        List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), JSONReader.madameBrandProducts(String.valueOf(i)), "Verify that can see products");
        }
    }
}
