@loginfeature
Feature: Login functionality
Background:
Given  user should be on login page 

Scenario Outline:T01_Invalidlogin 
When user enter  invalid login "<userid>" and password "<password>" and click on login button
Then user can see the error message

Examples:
|userid|password|
|admin111|admin111|
|admin222|admin222|
|admin333|admin333|

Scenario: T02_validlogin

When user entersvalid userid and password and click on login button
Then user can navigated to homepage
And logout link should be appear on right corner on the home page

