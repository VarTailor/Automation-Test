package com.bdd.browser;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SeleniumFactory {
    private static WebDriver driver;
    public static Properties prop;
    public static WebDriver getDriver(){
        if(driver==null){
            try{

                setDriver(System.getProperty("browser.name"));
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                setURL(System.getProperty("url"));

            }catch (Exception e){
                System.out.println("Browser creates exception " + e);
                e.printStackTrace();
            }
        }return driver;
    }
    private static void setDriver(String browser)throws Exception{
        switch (browser){
            case("chrome"):{
                setupChrome();
                break;
            }
            case("firefox"):{
                setupFireFox();
                break;
            }

        }
    }
    private static void setupChrome(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    private static void setupFireFox(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
    }

    private static void setURL(String url){
        switch (url) {
            case("QA"): {
                QA_Url();
                break;
            }
            case("DEV"):{
                Dev_Url();
                break;
            }

        }
    }

    private static void QA_Url(){
        driver.get("https://www.tkmaxx.com/uk/en/");
    }
    private static void Dev_Url(){
        driver.get("https://www.tkmaxx.com/uk/en/");
    }

}
