Feature: Test Example

  @Test
  Scenario: Login TO UI
    Given user on TKMaxx home page
    When Hover over or click on all present menu tabs
    When Select the "Men" tab from the main menu
    When Select the "Brand" filter and select multiple check boxs
    When User clicks on any product from the search result
    And User clicks on the Size Guide link
    When User goes back to the main page
    And User selects "S" and quantity from the dropdown
    And User clicks on the Add to Bag button
    And User clicks on View Bag
    When User clicks on the Checkout button
    And User chooses to Checkout as a guest
    Then User should see the error message "Please enter an email address"
