package com.bdd.stepdefinition;

import com.bdd.actionPages.APITest;
import com.bdd.actionPages.BaseClass;
import com.bdd.actionPages.HomePage;

import cucumber.api.java.bs.A;
import cucumber.api.java.en.Given;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class HomePageStepdefs extends BaseClass {
    HomePage homePage = new HomePage(driver);
    APITest apiTest = new APITest();

    public HomePageStepdefs(){
        super();
    }

    @Given("user on TKMaxx home page")
    public void userOnTKMaxxHomePage() throws IOException, ParseException {


    }

}
