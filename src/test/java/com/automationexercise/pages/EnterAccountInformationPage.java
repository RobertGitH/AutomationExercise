package com.automationexercise.pages;

import com.automationexercise.tests.TestBasic;
import com.automationexercise.utils.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EnterAccountInformationPage extends TestBasic {

    @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")
    private WebElement enterAccountInformation;

    @FindBy(id = "id_gender1")
    private WebElement titleMrCheckbox;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    private WebDriver driver;

    public EnterAccountInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getEnterAccountInformation() {
        return enterAccountInformation;
    }

    public AccountCreatedPage fillAccountDetails() {
        titleMrCheckbox.click();
        passwordInput.sendKeys(password + Util.generateCurrentDateAndTime());
        Select days = new Select(daysSelect);
        days.selectByValue(day);
        Select months = new Select(monthsSelect);
        months.selectByValue(month);
        Select years = new Select(yearsSelect);
        years.selectByValue(year);
        newsletterCheckbox.click();
        specialOffersCheckbox.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        address1Input.sendKeys(address1);
        address2Input.sendKeys(address2);
        Select countrySelector = new Select(countrySelect);
        countrySelector.selectByValue(country);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileNumberInput.sendKeys(mobileNumber);
        createAccountButton.click();
        return new AccountCreatedPage(driver);
    }
}
