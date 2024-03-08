package com.bdd.actionPages;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BaseClass{
    WebDriver driver;

    @FindBy (xpath = "//a/span[text()='Checkout as guest']") WebElement checkoutLink;
    @FindBy (id = "checkoutLoginSubmit") WebElement checkoutAsGuest;
    @FindBy (id = "j_username-error-message")  WebElement enterEmailErrorMessage;
    @FindBy (xpath = "//a[contains(text(),'Checkout')]") WebElement checkout;
    @FindBy (xpath = "//span[contains(text(),'Checkout as guest')]") WebElement guest;
    @FindBy (xpath = "//button[@name='checkoutLoginSubmit']") WebElement submit;
    @FindBy (xpath = "//div[@class='help-block']/span") WebElement errMsg;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutLink() {
        checkoutLink.click();
    }

    public void clickCheckoutAsGuest() {
        checkoutAsGuest.click();
    }

    public String enterEmailErrorMessage() {
        return enterEmailErrorMessage.getText();
    }

    public void checkoutValidation() {
        checkout.click();
        guest.click();
        submit.click();
        String errorMsg = errMsg.getText();
        Assert.assertEquals("Please enter an email address", errorMsg);
    }
}