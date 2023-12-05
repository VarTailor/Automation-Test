package com.bdd.actionPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class CheckOutPage extends BaseClass {
    public static WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'Guest')]")
    public WebElement guestCheckOutLink;

    @FindBy(xpath = "//button[@id='checkoutLoginSubmit']")
    public WebElement checkOutSubmitButton;

    @FindBy(xpath = "//span[contains(@id,'username.errors')]")
    public WebElement errorMessageText;

    public void clickGuestCheckOutLink(){
        clickElement(guestCheckOutLink);
    }
     public void clickGuestCheckOutSubmitButton(){
        clickElementByJSE(checkOutSubmitButton);
    }

    public String getErrorMessageFromCheckOutPage(){
        return errorMessageText.getText();
    }
}



