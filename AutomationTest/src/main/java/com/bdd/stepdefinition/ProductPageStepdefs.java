package com.bdd.stepdefinition;

import com.bdd.actionPages.APITest;
import com.bdd.actionPages.BaseClass;
import com.bdd.actionPages.HomePage;
import com.bdd.actionPages.ProductPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;

public class ProductPageStepdefs extends BaseClass {

    HomePage homePage = new HomePage(driver);
    ProductPage productPage= new ProductPage(driver);

    public ProductPageStepdefs() {
        super();
    }

    @Then("user gets the details of the product")
    public void user_gets_the_details_of_the_product() {
        System.out.println(productPage.getProductDetails());
    }

    @When("user clicks on Size guide link")
    public void user_clicks_on_link() {
        productPage.clickSizeGuideLink();
    }

    @Then("user verifies the page contains {string} text and goes back to main page")
    public void user_verifies_the_page_by_getting_text(String text) {
       Assert.assertEquals(productPage.getSizeGuideTitle(),text);
    }

    @When("user selects the {string} and {string} for the product from the dropdown")
    public void user_selects_the_and_from_the_dropdown(String size, String quantity)  {
        productPage.selectProductSize(Integer.parseInt(size));
        productPage.selectQuantity(Integer.parseInt(quantity));
    }

    @When("user clicks on Add to Bag button")
    public void user_clicks_on_button(){
        productPage.clickAddToCartButton();
    }

}