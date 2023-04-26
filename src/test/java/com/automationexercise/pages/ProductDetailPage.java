package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    @FindBy(css = "div[class='product-information'] h2")
    private WebElement productName;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    private WebElement productCategory;

    @FindBy(css = "div[class='product-information'] span span")
    private WebElement productPrice;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[2]")
    private WebElement productAvailability;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[3]")
    private WebElement productCondition;

    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[4]")
    private WebElement productBrand;

    @FindBy(id = "quantity")
    private WebElement quantityInput;

    @FindBy(css = "button[class='btn btn-default cart']")
    private WebElement addToCartButton;

    @FindBy(css = "p.text-center:nth-child(2) > a:nth-child(1)")
    private WebElement viewCartButton;

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductCategory() {
        return productCategory;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getProductAvailability() {
        return productAvailability;
    }

    public WebElement getProductCondition() {
        return productCondition;
    }

    public WebElement getProductBrand() {
        return productBrand;
    }

    public ProductDetailPage increaseQuantity(String value) {
        quantityInput.clear();
        quantityInput.sendKeys(value);
        return this;
    }

    public ProductDetailPage addToCartButtonClick() {
        addToCartButton.click();
        return this;
    }

    public CartPage viewCartButtonClick() {
        viewCartButton.click();
        return new CartPage(driver);
    }
}
