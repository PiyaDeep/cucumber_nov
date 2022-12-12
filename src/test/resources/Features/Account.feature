@accfeature
Feature: Account functionality
Background:
Given  user should be on login page 
When user entersvalid userid and password and click on login button

Scenario Outline: TC05_Account_creation_with_all_data
When user click on new account link 
Then create account page should be open  
When user account_name "<accname>" And  website  "<Website>" And ticketsymbol And   "<symbol>" And industry  "<industry>" and click on save button
Then Account created succefully
Examples:
|accname|Website|symbol|industry|
|Laxman|Priya@123 |vtiger  |Banking |


@sanity
Scenario: TC06_creatLeadAndAccount

When user click on new lead link
Then create lead page should be open 
When user click on mandatory field and click on save button 
And lead should be created succesfully

