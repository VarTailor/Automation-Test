package com.bdd.actionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class ViewCartPage extends BaseClass {
    public static WebDriver driver;

    public ViewCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='item-name']/p[1]")
    public WebElement productNameText;

    @FindBy(xpath = "//div[@class='item-name']/h3")
    public WebElement productBrandText;

    @FindBy(xpath = "//div[@class='clr basket-table-row']//div[@class='item-price']")
    public WebElement priceText;

    @FindBy(xpath = "//div[contains(@class,'checkoutBottomBtn')]//a[contains(text(),'Checkout')]")
    public WebElement checkoutButton;

    public void clickCheckoutButton(){
        clickElementByJSE(checkoutButton);
    }

    public HashMap getProductDetailsFromViewCartPage(){
        HashMap itemDetails=new HashMap<>();
        String price= priceText.getText().replaceAll("([A-Za-z]+[\\s])","").trim();
        itemDetails.put("productName",productNameText.getText());
        itemDetails.put("brandName", productBrandText.getText());
        itemDetails.put("price",price);
        return itemDetails;
    }
}



