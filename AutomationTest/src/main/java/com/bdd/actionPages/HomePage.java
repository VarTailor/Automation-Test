package com.bdd.actionPages;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
    public static WebDriver driver;

    @FindBy (xpath = "//header/div/div/a") WebElement header;
    @FindBy (xpath = "//ul[@class='nav nav-pills main-navigation-list']/li/a") List<WebElement> menuTabs;
    @FindBy (xpath = "//button[text()='ALLOW ALL']") WebElement cookie;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void verifyHeader() throws InterruptedException {
        String getheadertext = header.getText().trim();
        assertEquals("TK Maxx UK", getheadertext);
        System.out.println("Header validated: "+ getheadertext);
        Thread.sleep(20000);
        if(cookie.isDisplayed()) {
            Thread.sleep(2000);
            cookie.click();
        }
    }

    public void verifyHeaderLinks(Actions action) {
        for(WebElement e : menuTabs) {
            action.moveToElement(e).perform();
            System.out.println("Menu displayed "+e.getText());
        }
    }


}