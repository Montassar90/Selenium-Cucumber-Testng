@Login
Feature: Login

  # As a registred user
  # I want to acces to my account
  # So that I can use it
  Background: 
    Given The login section appears in home page

  Scenario: Succesful Login with valid credentials
    When I fill the login form
    And I click on the login button
    Then I should be redirected to my accounts overview page
    And I see a welcome message

  Scenario: Login with invalid password
    When I fill the login form with a valid username and an invalid password
    And I click on the login button
    Then I should see an error message
