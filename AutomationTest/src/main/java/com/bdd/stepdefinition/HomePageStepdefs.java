package com.bdd.stepdefinition;

import com.bdd.actionPages.APITest;
import com.bdd.actionPages.BaseClass;
import com.bdd.actionPages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


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
    
    @When("Hover over or click on all present menu tabs")
	public void clickOnAllMenuTabs() {
		homePage.hoverOrClickOnAllTabs();
	}

	@When("Select the {string} tab from the main menu")
	public void select_the_tab_from_the_main_menu(String tabName) throws Exception {
		homePage.selectMenuTab(tabName);

	}

	@When("Select the {string} filter and select multiple check boxs")
	public void select_the_filter_and_select_multiple_check_boxs(String filterOption) throws Exception {
		homePage.selectFilter(filterOption);
		homePage.selectBrandOptions();
	}

	@When("User clicks on any product from the search result")
	public void user_clicks_on_any_product_from_the_search_result() {

		homePage.selectProduct();
	}

	@When("User clicks on the Size Guide link")
	public void user_clicks_on_the_Size_Guide_link() {
		homePage.selectsizeGuide();
	}

	@When("User goes back to the main page")
	public void user_goes_back_to_the_main_page() {
		homePage.switchToNewTab(driver);
	}

	@When("User selects {string} and quantity from the dropdown")
	public void user_selects_and_quantity_from_the_dropdown(String size) throws Exception {
		homePage.selectSize(size);
	}

	@When("User clicks on the Add to Bag button")
	public void user_clicks_on_the_Add_to_Bag_button() {
		homePage.clickOnAddToCart();
	}

	@When("User clicks on View Bag")
	public void user_clicks_on_View_Bag() {
		homePage.clickViewBag();
	}

	@When("User clicks on the Checkout button")
	public void user_clicks_on_the_Checkout_button() {
		homePage.clickOnCheckOut();
	}

	@When("User chooses to Checkout as a guest")
	public void user_chooses_to_Checkout_as_a_guest() {
		homePage.clickonCheckoutAsGuest();
	}

	@Then("User should see the error message {string}")
	public void user_should_see_the_error_message(String expectedMsg) {
		homePage.validateErrorMessege(expectedMsg);
	}

}
