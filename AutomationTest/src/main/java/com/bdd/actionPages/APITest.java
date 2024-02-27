package com.bdd.actionPages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APITest extends BaseClass {
    public static WebDriver driver;

    @Test
    public  void Test_API() throws IOException, ParseException {


    }

}


