package com.bdd.actionPages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import static com.bdd.browser.SeleniumFactory.getDriver;

public class BaseClass{
    public static WebDriver driver;
    public static Properties prop;
    public Actions actions;
    public JavascriptExecutor js;


    public BaseClass(){

        final String configFileName = "config.properties";

        try {
            prop = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream(configFileName);
            if(is !=null) {
                prop.load(is);
            }else {
                throw new FileNotFoundException(String.format("File name %s not found ", configFileName));
            }

        } catch (IOException e) {

            e.getMessage();
        }

        driver = getDriver();
        actions=new Actions(driver);
        js=(JavascriptExecutor)driver;
    }

    //Hover over an element
    public void hoverOnElement(WebElement webElement){
        scrollIntoElement(webElement);
        actions.moveToElement(webElement).perform();
    }

    //click an element
    public void clickElement(WebElement element){
        scrollIntoElement(element);
        element.click();
    }

    //scroll into an element
    public void scrollIntoElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    //click element using javascriptexecutor
    public void clickElementByJSE(WebElement element) {
        scrollIntoElement(element);
        js.executeScript("arguments[0].click()",element);
    }



}
