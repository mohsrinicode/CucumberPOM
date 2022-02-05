Feature: Account Page Feature 

Background:
Given user has already logged in to application
|username|password|
|mohsrini@gmail.com|omsairam2021|

#Scenario: Accounts page title
#Given user is on Accounts page
#When user get the title of the page 
#Then page title should be "My account - My Store"

Scenario: Account section count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts sections count should be 6  



