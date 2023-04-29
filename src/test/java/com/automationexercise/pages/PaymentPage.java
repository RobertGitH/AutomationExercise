package com.automationexercise.pages;

import com.automationexercise.utils.JSONReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PaymentPage {

    @FindBy(css = "input[data-qa='name-on-card']")
    private WebElement nameOnCardInput;

    @FindBy(css = "input[data-qa='card-number']")
    private WebElement cardNumberInput;

    @FindBy(css = "input[data-qa='cvc']")
    private WebElement cvcInput;

    @FindBy(css = "input[data-qa='expiry-month']")
    private WebElement expirationMonthInput;

    @FindBy(css = "input[data-qa='expiry-year']")
    private WebElement expirationYearInput;

    @FindBy(css = "button[data-qa='pay-button']")
    private WebElement payAndConfirmOrderButton;

    @FindBy(xpath = "//div[contains(@id, 'success_message')]/div") //correct xpath but unable to locate an element
    private WebElement alertSuccess;

    @FindBy(css = "div[class='col-sm-9 col-sm-offset-1'] p")
    private WebElement successMessage;

    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PaymentPage fillPaymentDetails() throws IOException, ParseException {
        nameOnCardInput.sendKeys(JSONReader.paymentDetails("nameOnCard"));
        cardNumberInput.sendKeys(JSONReader.paymentDetails("cardNumber"));
        cvcInput.sendKeys(JSONReader.paymentDetails("cvc"));
        expirationMonthInput.sendKeys(JSONReader.paymentDetails("expirationMonth"));
        expirationYearInput.sendKeys(JSONReader.paymentDetails("expirationYear"));
        payAndConfirmOrderButton.click();
        return this;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }
}
