package com.bdd.actionPages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class HomePage extends BaseClass {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[contains(@class, 'main-navigation-list')]/li")
    public List<WebElement> homePageTabs;

    @FindBy(xpath = "//div[@id='miniCart']/a//i[@class='icon icon-bag']")
    public WebElement viewCartLink;


    public ArrayList<String> getHomePageMainTabs(){
        ArrayList<String> tabs= new ArrayList<String>();
        List<WebElement> tabsSelector=homePageTabs;
        for(WebElement ele1:tabsSelector){
            String tabName= ele1.getText();
            tabs.add(tabName);
        }
        return tabs;
    }

    public void hoverOnMainTab(String tabName) {
        WebElement tabOption= driver.findElement(By.xpath("//ul[contains(@class, 'main-navigation-list')]/li/a[contains(text(), '"+tabName+"')]"));
        hoverOnElement(tabOption);
    }

    // hover on secondary tab option
    public void hoverOnTabOptions(String tabName, String optionName){
        hoverOnMainTab(tabName);
        WebElement optionsName=driver.findElement(By.xpath("//div[@id='"+tabName+"CategoryLink']//li[@data-category='"+optionName+"']"));
        hoverOnElement(optionsName);
        clickElement(optionsName);
    }

    public void clickOptionLink(String tabName, String optionName, String linkName) {
        WebElement optionsLink=driver.findElement(By.xpath("(//li[contains(@data-categorypath,'"+tabName+"CategoryLink') and @data-categoryparent='"+optionName+"']/a[@title='"+linkName+"'])[1]"));
        hoverOnTabOptions(tabName,optionName);
        WebDriverWait wait =new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(optionsLink));
        optionsLink.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@title='Brand']"))));
    }

    public void clickDropdown(String drpName){
        WebElement dropDown=driver.findElement(By.xpath("//button[@title='"+drpName+"']"));
        clickElementByJSE(dropDown);
    }

    // select options from Brand dropdown
    public void selectOptionsFromBrandDropDown(String dropDownName, String options){
        ArrayList<String> allOptions= new ArrayList<>(Arrays.asList(options.split(",")));
        for(String option: allOptions){
            String optionName=option.replaceAll(" ","_").toLowerCase();
            clickElement(driver.findElement(By.xpath("//button[@title='"+dropDownName+"']/following-sibling::div//div[@class='c-refine__options-item']//button[@id='"+optionName+"']")));
        }
        clickElement(driver.findElement(By.xpath("//button[@title='"+dropDownName+"']//following::button[@class='c-refine__cta close'][1]")));
    }

    public void clickOnProductFromSearchResults(int productNumber){
        clickElement(driver.findElement(By.xpath("//ul[@class='c-product-grid']/li["+productNumber+"]//a")));
    }

    public void clickViewBag(){
        clickElement(viewCartLink);
    }


}


