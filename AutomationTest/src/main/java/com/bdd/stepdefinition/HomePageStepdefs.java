package com.bdd.stepdefinition;

import com.bdd.actionPages.APITest;
import com.bdd.actionPages.BaseClass;
import com.bdd.actionPages.HomePage;

import cucumber.api.java.bs.A;
import cucumber.api.java.en.*;
import org.testng.Assert;


import java.io.IOException;
import java.util.Arrays;

public class HomePageStepdefs extends BaseClass {
    HomePage homePage = new HomePage(driver);
    APITest apiTest = new APITest();

    public HomePageStepdefs(){
        super();
    }

    @Given("user on TKMaxx home page")
    public void userOnTKMaxxHomePage() {
        System.out.println("I am on Home page");

    }

    @Then("user validates {string} in Home page")
    public void userValidatesTabsInHomePage(String tabNames) {
        Assert.assertEquals(homePage.getHomePageMainTabs(), Arrays.asList(tabNames.split(",")),"Expected and actual home page tabs are not matching");
    }

    @When("user selects the tab {string} and option {string} and clicks on link {string}")
    public void user_selects_the_tab_and_option(String tabName, String optionName, String linkName) {
        homePage.clickOptionLink(tabName,optionName,linkName);
    }

    @When("user click on {string} and select {string} from the brand")
    public void user_click_on_and_select_from_the_brand(String dropdownName, String choices) {
        homePage.clickDropdown(dropdownName);
        homePage.selectOptionsFromBrandDropDown(dropdownName,choices);
    }

    @When("user click on {string} from the search results")
    public void user_click_on_from_the_search_results(String productNumber) {
        homePage.clickOnProductFromSearchResults(Integer.parseInt(productNumber));
    }

    @When("user clicks the view bag icon on Home page")
    public void user_clicks_the_view_bag_link_on_Home_page() {
        homePage.clickViewBag();
    }

}
