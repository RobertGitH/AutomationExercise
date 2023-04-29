package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage {

    @FindBy(xpath = "//ul[contains(@id, 'address_delivery')]//li")
    private List<WebElement> addressDelivery;
    @FindBy(xpath = "//ul[contains(@id, 'address_invoice')]//li")
    private List<WebElement> addressInvoice;

    @FindBy(xpath = "//section/div/div[5]/table/tbody/tr[3]/td[4]/p")
    private WebElement totalAmount;

    @FindBy(css = "textarea[name='message']")
    private WebElement comment;

    @FindBy(css = "a[href='/payment']")
    private WebElement placeOrderButton;

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> getAddressDelivery() {
        return addressDelivery
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAddressInvoice() {
        return addressInvoice
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getTotalAmount() {
        return totalAmount;
    }

    public PaymentPage enterComment(String text) {
        comment.sendKeys(text);
        placeOrderButton.click();
        return new PaymentPage(driver);
    }
}
