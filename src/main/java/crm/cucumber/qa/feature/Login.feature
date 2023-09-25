Feature: Login Functionality


  Scenario: Verify user is abe login successfully
    Given user is on login page
    When I enter "AmolDombale" as username
    When I enter "Amol@5793" as Password
    Then I click on login button

  Scenario: Verify company logo
    Given user is on login page
    When I verify the logo

  Scenario: Verify liknks on login page
    Given user is on login page
    When I verify the links

  Scenario: login to HRM App
    Given Browser is open
    And User is on login page1
    When I enter "username" as username
    When I enter "password" as Password  
    And User click on login
    Then user is navigate to home page
