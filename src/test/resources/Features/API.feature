@api
Feature: API functionality

Scenario: Test_ListUser01 
Given user should have endpoint url
When user send get request with Data
Then user will get responce 
And responce contains status code,email,page value

Scenario: Test_SingleUser02 
Given user should have endpoint singleurl
When user send get request with single Data
Then user will get responce of single user
And responce contains status code,id,email,first_name,last_name


Scenario: Test_CreatUsers03 
Given user should have endpoint createuserurl
When user send get request with craeteuser 
Then user will get responce of craeteuser 
And responce contains status code,name,job


Scenario: Test_UpdateUsers04 
Given user should have endpoint Updateurl
When user send get request with updateuser 
Then user will get responce of updateuser 
And responce contains to update  status code,name,job

Scenario: Test_DeleteUser05 
Given user should have endpoint Deleteurl
When user send get request with Deleteurl 
Then user will get responce of Deleteurl 
And responce contains to deleted User


Scenario: Test_SingleUserNotFound06 
Given user should have endpoint SingleuserNotfoundurl
When user send get request with SingleuserNotfoun 
Then user will get responce of SingleuserNotfoun 
And responce contains to SingleuserNotfoun

Scenario: Test_ListRecorces07 
Given user should have endpoint ListResourcesurl
When user send get request with ListResources Data
Then user will get responce of ListResources 
And responce contains page,name,id  ListResources

Scenario: Test_SingleRecorces08 
Given user should have endpoint SingleRecorcesurl
When user send get request with SingleRecorces Data 
Then user will get responce of SingleRecorces 
And responce contains id,name,year
