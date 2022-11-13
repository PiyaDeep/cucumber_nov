@leadfeature
Feature: Lead functionality
Background:
Given  user should be on login page 
When user entersvalid userid and password and click on login button

Scenario Outline: TC04_Lead_creation_with_all_data
When user click on new lead link 
Then create lead page should be open  
When user Salutation type ,firstname, lastname,company,leadsource,mobile,city,state and click on save button
Then lead created succefully
Examples:
|Salutation|firstname|lastname|company|leadsource|mobile|city|state|
|Mr.       |Priya    |Jagtap  |Airtel |call      |8355934901|pune|maharastra|



Scenario: TC03_creatLeadAndAccount

When user click on new lead link
Then create lead page should be open 
When user click on mandatory field and click on save button 
And lead should be created succesfully

