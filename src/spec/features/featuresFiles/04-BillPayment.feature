@BillPayment
Feature: Bill Payment Service

  # As a registred user
  # I want to acces to my account
  # And pay my bills
  Background: 
    Given The login section appears in home page
    When I fill the login form
    And I click on the login button
    Then I should be redirected to my accounts overview page
    And I click on the bill pay link

  Scenario: Acces to the bill pay service
    Then The bill payment service section should appears

  Scenario: Pay a bill with valid details
    When I fill the form with valid data
    And I click on the confirm button
    Then I should see a confirmation message of the payment process

  Scenario: Pay a bill with mismatch payee account ID verification
    When I fill the form with valid data
    And I fill the Verify Account field with data that does not match the ID field
    And I click on the confirm button
    Then I should see a mismatch error message
