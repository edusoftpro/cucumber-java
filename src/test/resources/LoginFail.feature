Feature: Login Functionality

  In order to do Internet Banking
  As a valid Para Bank customer
  I want to login	successfuly

Scenario Outline: Failed Login
  Given I am in login page of Para Bank Application
  When I enter valid <username> and <password> with <userFullName>
  Then I should be taken to Overview page

Examples:
  |username|password|userFullName|
  |"root"|"root"|"root"|
