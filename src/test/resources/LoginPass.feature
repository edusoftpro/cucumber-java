Feature: Login Functionality

  In order to do Internet Banking
  As a valid Para Bank customer
  I want to login	successfuly

#Scenario: Successful Login
#  Given I am in login page
#  When I enter valid <username> and <password>
#  Then I should be taken to Overview page

Scenario Outline: Successful Login
  Given I am in login page of Para Bank Application
  When I enter valid <username> and <password> with <userFullName>
  Then I should be taken to Overview page

Examples:
  |username|password|userFullName|
  |"admin"|"admin"|"admin"|
