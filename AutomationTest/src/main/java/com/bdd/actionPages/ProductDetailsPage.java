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
    @FindBy(xpath = "//div[@class='product-details']/p") WebElement productName;
    @FindBy(xpath = "//div[@class='product-details']/h1") WebElement productDescription;
    @FindBy(className = "item-price-original") WebElement productPrice;
    @FindBy(xpath = "//div[@class='product-rrp']/p") WebElement productRrp;
    @FindBy(xpath = "//div[@class='product-save-price u-font-bold u-colour-mu']/p") WebElement productDiscount;
    @FindBy(xpath = "//label[@class='variantlabel size-type-one']") WebElement size;
  

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void details() {
    	prod.click();
    	System.out.println("Name: "+productName.getText());
    	System.out.println("Description: "+productDescription.getText());
    	System.out.println("Price: "+productPrice.getText());
    	System.out.println("RRP: "+productRrp.getText());
    	System.out.println("Discount: "+productDiscount.getText());
		guide.click();

		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    Assert.assertEquals("Size Guide", hdrGuide.getText());
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    System.out.println(size.getText()+" :Size available");
	    size.click();
	    qty.click();
	    qty2.click();
	    cart.click();
	    viewCart.click();
    }
}