@OpenNewAccount
Feature: Open New Account

  # As a registred user
  # I want to acces to my account
  # And use the open new bank account service
  Background: 
    Given The login section appears in home page
    When I fill the login form
    And I click on the login button
    Then I should be redirected to my accounts overview page

  Scenario: I am able to acces to the open new account service
    When I click on the open new account link
    Then The open new account section should appears
