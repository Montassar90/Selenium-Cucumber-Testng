@Registration
Feature: Registration

  # As a new user
  # I want to register on the website
  # So that I can access my account and make purchases
  Background: 
    Given I navigate to the registration page

  Scenario: Successful registration with valid information
    When I fill the signup form
    And I click on the submit button
    Then I Should get logged in and see a succes message
 
