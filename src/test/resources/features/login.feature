 Feature: Login Page Feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"


Scenario: Forgot Passwword link
Given user is on login page
Then forgot you password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "mohsrini@gmail.com"
And user enters password "omsairam2021"
And user clicks on login button
Then user gets the title of the page
And Home page title should be "My account - My Store"