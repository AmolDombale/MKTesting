Feature: Create new product

  Scenario: Create new Product
    Given User is login to application
    When click on product link
    Then User enter Product details
      | Name    | Cost  | Retail_value | Wholesale | Sku | Inventory_amount | Description |
      | Shampoo |  10.9 |        20.10 |     10.55 |   2 |              100 | Good        |
      | Dell    | 30.89 |        30.20 |     20.66 |   4 |               50 | Very Godd   |
      | Mac     | 40.89 |        70.89 |     30.77 |   6 |               20 | Bad         |
    Then close the browser
