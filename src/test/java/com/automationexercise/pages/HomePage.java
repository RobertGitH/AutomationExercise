package com.automationexercise.pages;

import com.automationexercise.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage {

    @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement girlImgResponsive;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesButton;

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProduct1Button;

    //footer
    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement subscription;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(id = "success-subscribe")
    private WebElement alertSuccessSubscribe;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement homePageIsVisible() {
        return girlImgResponsive;
    }

    public LoginSignupPage signupLoginClick() {
        signupLoginButton.click();
        return new LoginSignupPage(driver);
    }

    public ContactUsPage contactUsButtonClick() {
        contactUsButton.click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage testCasesButtonClick() {
        testCasesButton.click();
        return new TestCasesPage(driver);
    }

    public ProductsPage productsButtonClick() {
        productsButton.click();
        return new ProductsPage(driver);
    }

    public CartPage cartButtonClick() {
        cartButton.click();
        return new CartPage(driver);
    }

    public ProductDetailPage viewProduct1ButtonClick() {
        viewProduct1Button.click();
        return new ProductDetailPage(driver);
    }

    //footer
    public WebElement getSubscription() {
        return subscription;
    }

    public HomePage fillSubscribe() throws IOException {
        subscribeEmailInput.sendKeys(PropertiesLoader.loadProperty("correct.email"));
        subscribeButton.click();
        return this;
    }

    public WebElement getAlertSuccessSubscribe() {
        return alertSuccessSubscribe;
    }

}


