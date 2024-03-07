package com.bdd.stepdefinition;

import java.io.IOException;
import java.sql.SQLException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.interactions.Actions;
import com.bdd.actionPages.APITest;
import com.bdd.actionPages.BaseClass;
import com.bdd.actionPages.CheckoutPage;
import com.bdd.actionPages.Database;
import com.bdd.actionPages.HomePage;
import com.bdd.actionPages.ProductCatalogPage;
import com.bdd.actionPages.ProductDetailsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class HomePageStepdefs extends BaseClass {
    HomePage homePage = new HomePage(driver);
    ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage (driver);
    CheckoutPage checkOutPage = new CheckoutPage(driver);
    Database dbpg = new Database();
    APITest apiTest = new APITest();

    public HomePageStepdefs(){
        super();
    }

    @Given("^user is on the TKMAXX homepage$")
    public void user_is_on_home_page_of_TK_Maxx() throws InterruptedException {
        System.out.println("Message: home page of TK Maxx loaded");
        homePage.verifyHeader();
    }

    @When("^validates menus in homepage & select Mens tab$")
    public void all_the_menu_tabs_are_displayed() {
        Actions action = new Actions(driver);
        homePage.verifyHeaderLinks(action);
    }

    @And("^user selects clothing category and dresses option$")
    public void hover_and_validate_all_the_menu_tabs() throws InterruptedException {
        Actions action = new Actions(driver);
        productCatalogPage.selectCategory(action);
    }

    @Then ("^select brands and filter products$")
    public void filterBrand() throws InterruptedException {
        productCatalogPage.brandSelection();
    }

    @And ("^user selects specific product & review details$")
    public void productSelect() {
        productDetailsPage.details();
    }

    @Then ("^error message should be displayed when user does checkout as guest without entering email id$")
    public void checkout_as_guest() {
        checkOutPage.checkoutValidation();
    }

    @When("^user tries to fetch records from database$")
    public void dbValidation() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        dbpg.dbTest();
    }

    @When ("^user has access to API & validates response$")
    public void apiTest() throws IOException, ParseException {
        apiTest.Test_API();
    }
}
