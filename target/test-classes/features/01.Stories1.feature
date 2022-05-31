Feature: Navigate to the website and perform scenario 1

  Background:
    Given the browser is initiated with url "http://automationpractice.com/index.php"

  Scenario: 1- Select the highest price item and add it to the cart
    When I Click on the Dresses Menu
    Then Select the highest price item
    And Add the selected highest price item to the cart
    And the message displayed "Product successfully added to your shopping cart"



