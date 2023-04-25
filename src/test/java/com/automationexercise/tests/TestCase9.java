package com.automationexercise.tests;

import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.PropertiesLoader;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Epic("Regression Tests")
@Feature("Search Product")
public class TestCase9 extends TestBasic {

    String search;

    {
        try {
            search = PropertiesLoader.loadProperty("search.product.input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(description = "Test Case 9: Search Product")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search Product")
    @Description("1. Launch browser\n" +
            "2. Navigate to url 'http://automationexercise.com'\n" +
            "3. Verify that home page is visible successfully\n" +
            "4. Click on 'Products' button\n" +
            "5. Verify user is navigated to ALL PRODUCTS page successfully\n" +
            "6. Enter product name in search input and click search button\n" +
            "7. Verify 'SEARCHED PRODUCTS' is visible\n" +
            "8. Verify all the products related to search are visible")
    public void searchProduct() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
        verifySearchedProductsIsVisible();
        verifyAllTheProductsRelatedToSearchAreVisible();
    }

    @Step("7. Verify 'SEARCHED PRODUCTS' is visible")
    private void verifySearchedProductsIsVisible() {
        String searchedProductsText = new ProductsPage(getDriver())
                .fillSearchProductInput(search)
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS", "7. Verify 'SEARCHED PRODUCTS' is visible");
    }

    @Step("8. Verify all the products related to search are visible")
    private void verifyAllTheProductsRelatedToSearchAreVisible() {
        List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();
        int productsNamesSize = productsNames.size();

        for (int i = 0; i < productsNamesSize; i++) {
            Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
            System.out.println(i + ". " + productsNames.get(i) + " - contain: " + search);
        }
    }
}
