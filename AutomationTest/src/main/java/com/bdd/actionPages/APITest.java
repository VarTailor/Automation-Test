package com.bdd.actionPages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    @Test
    public  void Test_API() {
        Response response= given()
                .when()
                .get("https://api.citybik.es/v2/networks")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
        String responseBody= response.getBody().asPrettyString();
        System.out.println(responseBody);
        JsonPath jsonPath= new JsonPath(responseBody);
        String country=jsonPath.getJsonObject("networks[3].location.country");
        System.out.println("country: "+country);
        float latitude=jsonPath.getJsonObject("networks[3].location.latitude");
        System.out.println("latitude: "+latitude);
        float longitude=jsonPath.getJsonObject("networks[3].location.latitude");
        System.out.println("longitude: "+longitude);
    }

}


