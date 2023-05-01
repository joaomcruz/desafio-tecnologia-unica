@Alltests

Feature: Add item to shopping cart

  Background:
    Given I access magazine luiza website

  @AddProductToCartSearchBox
  Scenario Outline: Add one product to the shopping cart through clicking the search button
    And I search for a product clicking on the search button <productToSearch>
    Then I confirm that the search returned the searched product
    And I select one product from the list
    Then I check that I was redirected to the products page that I clicked
    And I click to add it to the cart
    Then I check the product name
    And I proceed to the order resume
    Then I confirm that I am on the cart page
    And I set the product amount <amount>
    Then I confirm the product amount


    Examples:
      | productToSearch | amount |
      | geladeira       | 1      |
      | mesa            | 3      |


  @AddProductToCartDropdown
  Scenario Outline: Add one product to the shopping cart through clicking the dropdown
    And I search for a product clicking on the dropdown
    Then I confirm that the search returned the searched product from the dropdown
    And I select one product from the list
    Then I check that I was redirected to the products page that I clicked
    And I click to add it to the cart
    Then I check the product name from the dropdown menu
    And I proceed to the order resume
    Then I confirm that I am on the cart page
    And I set the product amount <amount>
    Then I confirm the product amount


    Examples:
         | amount |
        | 4      |
