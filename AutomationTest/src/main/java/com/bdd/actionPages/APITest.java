package com.bdd.actionPages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.path.json.JsonPath;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APITest{

    @Test
    public  void Test_API() throws IOException, ParseException {
        try{
            Response rsp = given().
                    when().
                    contentType("application/json").
                    get("https://api.citybik.es/v2/networks").
                    then().
                    extract().
                    response();
            System.out.println(rsp.getStatusCode());
            ResponseBody body = rsp.getBody();
            System.out.println(body.asString());
            JsonPath jsp = rsp.jsonPath();
            String str = jsp.get("$.networks[?(@.location['country']=='RU')].location");
            System.out.println(str);
        }
        catch(Exception e){
            System.out.println(e + "Test Case failed in API test");
            e.printStackTrace();
        }
    }
}


