Feature: Deals
@sanity
  Scenario: Create new deals
    Given user is on login page
    When I enter "username" as username
    When I enter "password" as Password
    Then I click on login button
    When click on new deal link
    Then User enter deals details
      | Title               | Company  | Primary Contact | Amount | Probability | Commission | Identifier | Quantity | Type | Source            |
      | Mechanical engineer | Mahindra |           56789 |     10 |           2 |        100 | QA         |     2000 | New  | Existing Customer |
      | Civil Engineer      | Hilti    |           56789 |     20 |           4 |         50 | Dev        |     3000 | Old  | Online            |
      | Quality Analyst     | FIS      |           56789 |     30 |           6 |         20 | Devpos     |     4000 | New  | Partner           |
    Then close the browser

  @sanity @regression
  Scenario Outline: Create new deals with ScenarioOutline
    Given User is login to application
    When click on new deal link
    Then User enters "<Title>" and "<Company>" and "<Primary_Contact>"
    And User enters "<Amount>" and "<Probability>" and "<Commission>" and "<Identifier>"
    And User enters "<Quantity>" and "<Type>" and "<Source>" deals details
    Then close the browser

    Examples: 
      | Title               | Company  | Primary Contact | Amount | Probability | Commission | Identifier | Quantity | Type | Source            |
      | Mechanical engineer | Mahindra |           56789 |     10 |           2 |        100 | QA         |     2000 | New  | Existing Customer |
      | Civil Engineer      | Hilti    |           56789 |     20 |           4 |         50 | Dev        |     3000 | Old  | Online            |
      | Quality Analyst     | FIS      |           56789 |     30 |           6 |         20 | Devpos     |     4000 | New  | Partner           |
    
