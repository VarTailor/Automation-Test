package com.bdd.actionPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogPage extends BaseClass{
    WebDriver driver;

    @FindBy (xpath = "//ul[@class='nav nav-pills main-navigation-list']/li/a[@title='Women']") WebElement women;
    @FindBy (xpath = "//li[@data-categoryid='WomenClothingMMNode']") WebElement clothing;
    @FindBy (xpath = "//a[text()='Dresses']") WebElement dressesLink;
    @FindBy (xpath= "//button[@title='Brand']") WebElement btnBrand;
    @FindBy (xpath= "//button[@value='brand:adrianna_papell']") WebElement opt1;
    @FindBy (xpath= "//button[@value='brand:ahluwalia']") WebElement opt2;
    @FindBy (xpath= "//button[@class='c-refine__cta close']") WebElement close;

    public ProductCatalogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCategory(Actions action) throws InterruptedException {
        action.moveToElement(women).perform();
        action.moveToElement(clothing).perform();

        Thread.sleep(5000);
        System.out.println("Option displayed & Clicked: "+ dressesLink.getText());
        dressesLink.click();
    }

    public void brandSelection() throws InterruptedException {
        Thread.sleep(20000);
        System.out.println("Option clicked: "+btnBrand.getText());
        btnBrand.click();
        System.out.println("Brand Selected: "+opt1.getText());
        opt1.click();
        System.out.println("Brand Selected: "+opt2.getText());
        opt2.click();
        close.click();
    }
}
