package com.bdd.actionPages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APITest extends BaseClass {
    public static WebDriver driver;

    public static final String API_URL = "https://api.citybik.es/v2/networks";


	@Test
	public void Test_API() throws Exception {

		Response response = RestAssured.get(API_URL);
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());

        String countryName = "Germany";
        String countryLatitude = response.path("networks.find { it.location.country == '" + countryName + "' }.location.latitude");
        String countryLongitude = response.path("networks.find { it.location.country == '" + countryName + "' }.location.longitude");

        System.out.println("Country: " + countryName);
        System.out.println("Latitude: " + countryLatitude);
        System.out.println("Longitude: " + countryLongitude);
	}

}


