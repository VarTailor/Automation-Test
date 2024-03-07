@Test
Feature: TKMAXX Website Navigation and Purchase Flow

  Scenario: Add products to bag and checkout as guest
    Given user is on the TKMAXX homepage
    When validates menus in homepage & select Mens tab
    And user selects clothing category and dresses option
    Then select brands and filter products
    And user selects specific product & review details
    Then error message should be displayed when user does checkout as guest without entering email id

#@Database
  #Scenario: Validating Database
    #When user tries to fetch records from database
#
#@API
  #Scenario: Verifying API reponse code & body
    #When user has access to API & validates response