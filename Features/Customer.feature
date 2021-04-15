Feature: add new customer

Background:
 Given User Launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And click on Login
    Then User can see Dashboard
    When User click on customers menu
    And click on customers menu item
    
Scenario: add new Customer functionality
    Then user can view Add new customer page
    When user enter customer info
    And click on save
    Then user can see confirmation message "The new customer has been added"
    And close browser
    
Scenario: search Customer by email
	 	And enter customer email
		When click on search button
		Then user should found email in the search table
		And close browser
		
Scenario: search Customer by name
	 	And enter customer fname
	 	And enter customer lname
		When click on search button
		Then user should found name in the search table
		And close browser
    