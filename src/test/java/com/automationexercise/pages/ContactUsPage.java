package com.automationexercise.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    @FindBy(css = "h2.title:nth-child(2)")
    private WebElement getInTouch;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "subject")
    private WebElement subjectInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(name = "upload_file")
    private WebElement uploadFileInput;

    @FindBy(name = "submit")
    private WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    private WebElement alertSuccess;

    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement homePageButton;

    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getGetInTouch() {
        return getInTouch;
    }

    public ContactUsPage fillForm() {
        nameInput.sendKeys("Robert");
        emailInput.sendKeys("robert@test.pl");
        subjectInput.sendKeys("Test subject");
        messageInput.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc lobortis eros eget cursus placerat. " +
                "Pellentesque id porttitor est. Morbi aliquet massa sit amet finibus fermentum. Pellentesque eu ante a nunc pulvinar blandit a a orci." +
                " Mauris massa tellus, posuere vitae ante vel, feugiat sodales ante. Suspendisse commodo diam venenatis scelerisque ornare.");
        uploadFileInput.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\sample.txt");
        return this;
    }

    public ContactUsPage submitButtonClick() {
        submitButton.click();
        return this;
    }

    public ContactUsPage okButtonClick() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public WebElement getAlertSuccess() {
        return alertSuccess;
    }

    public HomePage homePageButtonClick() {
        homePageButton.click();
        return new HomePage(driver);
    }
}
