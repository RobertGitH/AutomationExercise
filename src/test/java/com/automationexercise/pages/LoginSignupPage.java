package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignupPage {

    @FindBy(css = "div[class='login-form'] h2")
    private WebElement loginToYourAccount;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "div[class='signup-form'] h2")
    private WebElement newUserSignup;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    private WebDriver driver;

    public LoginSignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getNewUserSignup() {
        return newUserSignup;
    }

    public EnterAccountInformationPage fillSignup(String name, String email) {
        signupNameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
        signupButton.click();
        return new EnterAccountInformationPage(driver);
    }

    public WebElement getLoginToYourAccount() {
        return loginToYourAccount;
    }

    public HomePageLogged fillLogin(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
        return new HomePageLogged(driver);
    }
}
