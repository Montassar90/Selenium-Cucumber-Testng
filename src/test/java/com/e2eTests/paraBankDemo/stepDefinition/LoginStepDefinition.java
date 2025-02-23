package com.e2eTests.paraBankDemo.stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.e2eTests.paraBankDemo.pageObject.LoginPageObject;
import com.e2eTests.paraBankDemo.utils.ConfigFileReader;
import com.e2eTests.paraBankDemo.utils.FakerDataGenerator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	// Object for interacting with login page elements
	private LoginPageObject loginPageObject;

	// Object for reading configuration properties
	private ConfigFileReader configFileReader;

	// Constructor to initialize page object and config reader
	public LoginStepDefinition() {
		loginPageObject = new LoginPageObject();
		configFileReader = new ConfigFileReader();
	}

	// Step definition to verify if the login section is displayed on the home page
	@Given("The login section appears in home page")
	public void theLoginSectionAppearsInHomePage() {
		try {
			// Asserts if login panel is displayed
			assertTrue(loginPageObject.getLoginPanel().isDisplayed());
		} catch (NullPointerException e) {
			// Logs a message if login panel is null
			System.err.println("Login panel is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any unexpected errors
			System.err.println(
					"An unexpected error occurred while verifying the Login panel visibility: " + e.getMessage());
		}
	}

	// Step definition to fill out the login form with credentials
	@When("I fill the login form")
	public void iFillTheLoginForm() {
		// Uses the login page object to input credentials from generated Fake data
		loginPageObject.performLoginFill(FakerDataGenerator.getUsername(),
				FakerDataGenerator.getPassword());
	}

	// Step definition to submit the login form
	@When("I click on the login button")
	public void iClickOnTheLoginButton() {
		// Calls method to click on the login button
		loginPageObject.submitLoginForm();
	}

	// Step definition to verify redirection to the accounts overview page
	@Then("I should be redirected to my accounts overview page")
	public void iShouldBeRedirectedToMyAccountsOverviewPage() {
		try {
			// Asserts if the accounts overview page title is displayed
			assertTrue(loginPageObject.getPageTitle().isDisplayed());
		} catch (NullPointerException e) {
			// Logs a message if the page title is null
			System.err.println("Page title is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any unexpected errors
			System.err.println(
					"An unexpected error occurred while verifying the Page title visibility: " + e.getMessage());
		}
	}

	// Step definition to verify the presence of a welcome message
	@Then("I see a welcome message")
	public void iSeeAWelcomeMessage() {
		try {
			// Retrieves actual welcome message text and constructs expected message
			String actualMsg = loginPageObject.getWelcomeMsg().getText();
			String expectedMsg = "Welcome " + FakerDataGenerator.getFirstname() + " "
					+ FakerDataGenerator.getLasttname();
			// Compares actual message with expected message
			assertEquals(actualMsg, expectedMsg);
		} catch (NullPointerException e) {
			// Logs a message if welcome message element is null
			System.err.println("Welcome message is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any unexpected errors
			System.err.println("An unexpected error occurred while verifying the Welcome message: " + e.getMessage());
		}
	}

// Step definition to perform login with invalid password 
	@When("I fill the login form with a valid username and an invalid password")
	public void iFillTheLoginFormWithAValidUsernameAndAnInvalidPassword() {
		// Uses the login page object to input credentials from generated Fake data
		loginPageObject.performLoginFill(FakerDataGenerator.getUsername(),
				FakerDataGenerator.getInvalidpw());

	}

	// Step definition to verify the presence of error message
	@Then("I should see an error message")
	public void iShouldSeeAnErrorMessage() {
		try {
			String actualMsg = loginPageObject.getErrorMsg().getText();
			String expectedMsg = configFileReader.getProperties("loginErrorMsg");
			assertEquals(actualMsg, expectedMsg);
		} catch (NullPointerException e) {
			// Logs a message if error message element is null
			System.err.println("Error message is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any unexpected errors
			System.err.println("An unexpected error occurred while verifying the Error message: " + e.getMessage());
		}
	}

}
