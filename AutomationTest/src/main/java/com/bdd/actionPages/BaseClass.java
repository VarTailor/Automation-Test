package com.bdd.actionPages;


import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

import static com.bdd.browser.SeleniumFactory.getDriver;

public class BaseClass{
    public static WebDriver driver;
    public static Properties prop;
    private static final String configFileName = "config.properties";

    public BaseClass(){

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
            //Add a logger
        }
        driver = getDriver();
    }
}