package com.bdd.stepdefinition;

import com.bdd.actionPages.*;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class CheckOutPageStepdefs extends BaseClass {

    CheckOutPage checkOutPage= new CheckOutPage(driver);

    public CheckOutPageStepdefs() {
        super();
    }

    @When("user clicks Checkout as Guest link option")
    public void user_clicks_Checkout_as_Guest_link_option() {
        checkOutPage.clickGuestCheckOutLink();
    }

    @When("user clicks Checkout as Guest submit button on Checkout page")
    public void user_clicks_submit_button_on_Checkout_page() {
        checkOutPage.clickGuestCheckOutSubmitButton();
    }

    @Then("user verifies the error message {string} for email")
    public void user_verifies_the_error_message_for_email(String errorMsg) {
        Assert.assertEquals(checkOutPage.getErrorMessageFromCheckOutPage(),errorMsg);
    }

}