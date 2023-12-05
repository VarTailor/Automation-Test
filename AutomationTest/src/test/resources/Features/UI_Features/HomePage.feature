Feature: Test Example

  @Test
  Scenario Outline: Login TO UI
    Given user on TKMaxx home page
    Then user validates "<all tabs>" in Home page
    When user selects the tab "<tabName>" and option "<optionName>" and clicks on link "<linkName>"
    And user click on "<dropdownName>" and select "<choices>" from the brand
    And user click on "<productNumber>" from the search results
    And user gets the details of the product
    And user clicks on Size guide link
    Then user verifies the page contains "Size Guide" text and goes back to main page
    When user selects the "<size>" and "<quantity>" for the product from the dropdown
    And user clicks on Add to Bag button
    And user clicks the view bag icon on Home page
    Then user verifies the details of selected product
    When user clicks on Checkout button
    And user clicks Checkout as Guest link option
    And user clicks Checkout as Guest submit button on Checkout page
    Then user verifies the error message "Please enter an email address" for email


    Examples:
      | all tabs                                                       |tabName| optionName | linkName| dropdownName|choices|productNumber|size|quantity|
      | Christmas,New In,Women,Men,Kids & Baby,Home,Beauty,Gifts,Clearance|Men| Winter Shop | View All| Brand|883 Police,Adidas|1|1|1|

