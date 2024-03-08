package com.bdd.actionPages;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.given;

public class APITest{

    @Test(description = "API Test")
    public  void Test_API() {
        try{
            Response rsp = given().
                    when().
                    contentType("application/json").
                    get("https://api.citybik.es/v2/networks").
                    then().
                    extract().
                    response();
            System.out.println(rsp.getStatusCode());
            //Add assertions
            ResponseBody body = rsp.getBody();
            System.out.println(body.asString());
            JsonPath jsp = rsp.jsonPath();
            String str = jsp.getString("networks.find {it.location['country'] == 'RU'}.location");
            System.out.println(str);
        }
        catch(Exception e){
            System.out.println(e + "Test Case failed in API test");
            //Logger
            e.printStackTrace();
        }
    }
}


