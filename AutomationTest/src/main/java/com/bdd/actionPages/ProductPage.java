package com.bdd.actionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class ProductPage extends BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='product-details']//h1")
    public WebElement productName;

    @FindBy(xpath = "//div[@class='product-details']/p")
    public WebElement productBrand;

    @FindBy(xpath = "//button[@class='size-guide-link']")
    public WebElement sizeGuideLink;

    @FindBy(xpath = "//div[@class='title']//h1")
    public WebElement sizeGuideTitleText;

    @FindBy(xpath = "//div[contains(@class,'qty-selector')]//b")
    public WebElement quantitySelectorButton;

    @FindBy(xpath = "//div[@class='product-price']/p[contains(@class,'item-price')]")
    public WebElement priceText;

    @FindBy(xpath = "//button[@id='addToCartButton']")
    public WebElement addToCartButton;


    public HashMap getProductDetails(){
        HashMap prodDetails=new HashMap<>();
        prodDetails.put("productName",productName.getText());
        prodDetails.put("brandName",productBrand.getText());
        prodDetails.put("price",priceText.getText());
        System.setProperty("productDetails", String.valueOf(prodDetails));
        System.out.println(System.getProperty("productDetails"));
       return prodDetails;
     }

    public void clickSizeGuideLink() {
        clickElementByJSE(sizeGuideLink);
    }

    public String getSizeGuideTitle() {
        String text="";
        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        //switch to active tab
        driver.switchTo().window(wid.get(1));
        text=sizeGuideTitleText.getText();
        System.out.println("Page title: "+ text);
        //switch to parent
        driver.switchTo().window(wid.get(0));
        return text;
    }

    public void selectProductSize(int option){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='radio-container']["+option+"]//label[contains(@for,'size-option')]")));
        WebElement size = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='radio-container']["+option+"]//label[contains(@for,'size-option')]")));
        clickElementByJSE(size);
    }

    public void selectQuantity(int qty){
        clickElementByJSE(quantitySelectorButton);
        clickElementByJSE(driver.findElement(By.xpath("//ul[@id='pdp-quantity_listbox']/li["+qty+"]")));
    }

    public void clickAddToCartButton() {
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        clickElementByJSE(addToCartButton);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='miniCart']/a/span/span"))));
        }
}
