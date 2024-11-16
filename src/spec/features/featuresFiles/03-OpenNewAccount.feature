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
    And I click on the open new account link

  Scenario: I am able to acces to the open new account service
    Then The open new account section should appears

  Scenario: I create a new checking account
    When I select "CHECKING" account from the account type dropdown
    And I click on the open new account button
    Then I should see a confirmation message
    And I should see my new account ID number

  Scenario: I create a new savings account
    When I select "SAVINGS" account from the account type dropdown
    And I click on the open new account button
    Then I should see a confirmation message
    And I should see my new account ID number
