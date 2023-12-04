package com.bdd.actionPages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HomePage extends BaseClass {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    }


