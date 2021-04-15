Feature: Login

  Scenario: successful login with valid credentials
    Given User Launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Then page title should be "Your store. Login"
    And close browser

  Scenario Outline: Login with Data Driven
    Given User Launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "<email>" and password as "<password>"
    And click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Then page title should be "Your store. Login"
    And close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@yourstore.com | admin123 |
