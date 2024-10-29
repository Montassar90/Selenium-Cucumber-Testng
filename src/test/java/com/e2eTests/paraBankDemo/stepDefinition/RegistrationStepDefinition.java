package com.e2eTests.paraBankDemo.stepDefinition;

import static org.testng.Assert.assertEquals;

import com.e2eTests.paraBankDemo.pageObject.RegistrationPageObject;
import com.e2eTests.paraBankDemo.utils.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// This class defines the step definitions for the registration feature in the ParaBank demo application.
public class RegistrationStepDefinition {

	// Declaration of page object and configuration reader objects to be used within
	// this class.
	public RegistrationPageObject registrationPageObject;
	public ConfigFileReader configFileReader;

	// Constructor to initialize the page object and configuration reader.
	public RegistrationStepDefinition() {
		registrationPageObject = new RegistrationPageObject(); // Initializes the RegistrationPageObject
		configFileReader = new ConfigFileReader(); // Initializes the ConfigFileReader for loading configurations
	}

	// Step definition for navigating to the registration page.
	@Given("I navigate to the registration page")
	public void iNavigateToTheRegistrationPage() {
		registrationPageObject.navigateToSignUp(); // Calls the navigateToSignUp() method to access the sign-up page.
	}

	// Step definition for filling out the registration form.
	@When("I fill the signup form")
	public void iFillTheSignupForm() {
		registrationPageObject.performFormFill(); // Fills out the registration form with predefined data.
	}

	// Step definition for clicking the submit button on the registration form.
	@When("I click on the submit button")
	public void iClickOnTheSubmitButton() {
		registrationPageObject.submitForm(); // Clicks the submit button to submit the form.
	}

	// Step definition to verify that the registration was successful and a success
	// message is displayed.
	@Then("I Should get logged in and see a succes message")
	public void IShouldGetLoggedInAndSeeASuccessMessage() {
		try {
			// Retrieves the actual success message displayed on the UI.
			String actualMsg = registrationPageObject.getSuccessMsg().getText();
			// Retrieves the expected success message from the configuration file.
			String expectedMsg = configFileReader.getProperties("registrationSuccesMsg");
			// Asserts that the actual message matches the expected message.
			assertEquals(actualMsg, expectedMsg, "The success message does not match.");
		} catch (NullPointerException e) {
			// Logs an error if the success message element is not found or is null.
			System.err.println("Success message element is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any other unexpected errors encountered during the assertion.
			System.err.println("An unexpected error occurred while verifying the success message: " + e.getMessage());
		}
	}
	
	@Then("I Should see an error message")
	public void IShouldSeeAnErrorMessage() {
		try {
			// Retrieves the actual error message displayed on the UI.
			String actualMsg = registrationPageObject.getUserNameError().getText();
			// Retrieves the expected success message from the configuration file.
			String expectedMsg = configFileReader.getProperties("registrationErrorMsg");
			// Asserts that the actual message matches the expected message.
			assertEquals(actualMsg, expectedMsg, "The error message does not match.");
		} catch (NullPointerException e) {
			// Logs an error if the success message element is not found or is null.
			System.err.println("Error message element is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any other unexpected errors encountered during the assertion.
			System.err.println("An unexpected error occurred while verifying the error message: " + e.getMessage());
		}
	}
}
