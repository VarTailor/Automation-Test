package com.bdd.stepdefinition;

import com.bdd.actionPages.*;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.HashMap;

public class ViewCartPageStepdefs extends BaseClass {

    HomePage homePage = new HomePage(driver);
    ProductPage productPage= new ProductPage(driver);

    ViewCartPage viewCartPage=new ViewCartPage(driver);

    public ViewCartPageStepdefs() {
        super();
    }

    @When("user clicks the view bag link on Home page")
    public void user_clicks_the_view_bag_link_on_Home_page() {
        homePage.clickViewBag();
    }

    @Then("user verifies the details of selected product")
    public void user_verifies_the_details_of_selected_product() {
        HashMap prodDetails= new HashMap<>();
        String Proddetails=System.getProperty("productDetails");
        Proddetails=Proddetails.substring(1, Proddetails.length()-1);
        String [] details=Proddetails.split(",");
        for(String kvps: details){
            String kvp [] = kvps.split("=");
            prodDetails.put(kvp[0].trim(), kvp[1].trim());
        }
        Assert.assertEquals(prodDetails,viewCartPage.getProductDetailsFromViewCartPage());
    }

    @When("user clicks on Checkout button")
    public void user_clicks_on_Checkout_button() {
       viewCartPage.clickCheckoutButton();
    }

}