package com.automationexercise.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement girlImgResponsive;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLogin;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("3. Verify that home page is visible successfully")
    public WebElement homePageVisible() {
        return girlImgResponsive;
    }

    @Step("4. Click on 'Signup / Login' button")
    public LoginSignupPage signupLoginClick() {
        signupLogin.click();
        return new LoginSignupPage(driver);
    }
}


