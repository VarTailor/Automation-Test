package com.bdd.actionPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;

public class ProductDetailsPage extends BaseClass {
    public static WebDriver driver;
    @FindBy (xpath= "//a[@class='c-product-card']") WebElement prod;
    @FindBy (xpath = "//button[text()='Size guide']") WebElement guide;
    @FindBy (xpath = "//div[contains(@aria-label,'Quantity')]") WebElement qty;
    @FindBy (xpath = "//ul[contains(@aria-label,'Quantity')]/li[1]") WebElement qty2;
    @FindBy (xpath = "//h1[@class='o-default-banner-section']") WebElement hdrGuide;
    @FindBy (xpath = "//button[contains(text(),'Add to bag')]") WebElement cart;
    @FindBy (xpath = "//a[contains(text(),'View bag')]") WebElement viewCart;


    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void details() {
        prod.click();
        guide.click();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
	    Assert.assertEquals("Size Guide", hdrGuide.getText());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        qty.click();
        qty2.click();
        cart.click();
        viewCart.click();
    }
}