package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {

    @FindBy(css = ".title.text-center")
    private WebElement titleTextCenter;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductOfFirstProductButton;

    @FindBy(id = "search_product")
    private WebElement searchProductInput;

    @FindBy(id = "submit_search")
    private WebElement submitSearchInput;

    @FindBy(xpath = "//div[contains(@class, 'productinfo text-center')]//p")
    private List<WebElement> searchResultsNames;

    @FindBy(css = "a[data-product-id='1']")
    private WebElement addToCartButton1;

    @FindBy(css = "a[data-product-id='2']")
    private WebElement addToCartButton2;

    @FindBy(css = "button[data-dismiss='modal']")
    private WebElement continueShoppingButton;

    @FindBy(css = "a[href='/view_cart'] u")
    private WebElement viewCartButton;

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getTitleTextCenter() {
        return titleTextCenter;
    }

    public ProductDetailPage viewProductOfFirstProductButtonClick() {
        viewProductOfFirstProductButton.click();
        return new ProductDetailPage(driver);
    }

    public ProductsPage fillSearchProductInput(String searchProduct) {
        searchProductInput.sendKeys(searchProduct);
        submitSearchInput.click();
        return this;
    }

    public List<String> getProductsSearchNames() {
        return searchResultsNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public CartPage addProductsToCart() {
        addToCartButton1.click();
        continueShoppingButton.click();
        addToCartButton2.click();
        viewCartButton.click();
        return new CartPage(driver);
    }
}

