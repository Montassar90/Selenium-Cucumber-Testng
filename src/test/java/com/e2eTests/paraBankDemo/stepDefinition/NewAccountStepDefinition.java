package com.e2eTests.paraBankDemo.stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import com.e2eTests.paraBankDemo.pageObject.NewAccountPageObject;
import com.e2eTests.paraBankDemo.utils.BrowserUtils;
import com.e2eTests.paraBankDemo.utils.ConfigFileReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewAccountStepDefinition {
	// Object for interacting with login page elements
	private NewAccountPageObject newAccountPageObject;

	// Object for reading configuration properties
	private ConfigFileReader configFileReader;

	// Object for interacting with BrowserUtils class
	private BrowserUtils browserUtils;

	// Constructor to initialize page object and config reader
	public NewAccountStepDefinition() {
		newAccountPageObject = new NewAccountPageObject();
		configFileReader = new ConfigFileReader();
		browserUtils = new BrowserUtils();
	}

	@Then("I click on the open new account link")
	public void iClickOnTheOpenNewAccountLink() {
		browserUtils.explicitVisibleWait(newAccountPageObject.getNewAccountLink());
		browserUtils.explicitClickableWait(newAccountPageObject.getNewAccountLink());
		// Navigates to the 'Open New Account' page
		newAccountPageObject.navigateToNewAccountLink();
	}

	@Then("The open new account section should appears")
	public void theOpenNewAccountSectionShouldAppears() {

		try {
			// Retrieves actual section title text and constructs expected message
			String actualMsg = newAccountPageObject.getPageTitle().getText();
			String expectedMsg = configFileReader.getProperties("openNewAccountTitle");
			// Compares actual message with expected message
			assertEquals(actualMsg, expectedMsg);
		} catch (NullPointerException e) {
			// Logs a message if section title element is null
			System.err.println("Section title is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any unexpected errors
			System.err.println("An unexpected error occurred while verifying the section title: " + e.getMessage());
		}
	}

	@When("I select {string} account from the account type dropdown")
	public void iSelectAccountFromTheAccountTypeDropdown(String type) {
		// Selects the specified account type from the dropdown
		newAccountPageObject.selectAccountType(type);
	}

	@When("I click on the open new account button")
	public void iClickOnTheOpenNewAccountButton() {
		browserUtils.explicitVisibleWait(newAccountPageObject.getNewAccountBtn());
		browserUtils.explicitClickableWait(newAccountPageObject.getNewAccountBtn());
		// Clicks the 'Open New Account' button
		newAccountPageObject.clickOnOpenNewAccountBtn();
	}

	@Then("I should see a confirmation message")
	public void iShouldSeeAConfirmationMessage() {
		try {
			browserUtils.explicitVisibleWait(newAccountPageObject.getNewAccountConfirmMsg());
			// Retrieves the actual confirmation message text from the page
			String actualMsg = newAccountPageObject.getNewAccountConfirmMsg().getText();
			// Gets the expected confirmation message from configuration properties
			String expectedMsg = configFileReader.getProperties("openNewAccountConfirm");

			assertEquals(actualMsg, expectedMsg);
		} catch (NullPointerException e) {
			// Logs a message if confirmation message element is null
			System.err.println("Confirmation message is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any unexpected errors
			System.err.println(
					"An unexpected error occurred while verifying the confirmation message: " + e.getMessage());
		}
	}

	@Then("I should see my new account ID number")
	public void iShouldSeeMyNewAccountIdNumber() {
		try {
			browserUtils.explicitVisibleWait(newAccountPageObject.getNewAccountId());
			assertTrue(newAccountPageObject.getNewAccountId().isDisplayed());
		} catch (NullPointerException e) {
			// Logs a message if confirmation message element is null
			System.err.println("Account ID is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any unexpected errors
			System.err.println("An unexpected error occurred while verifying the Account ID: " + e.getMessage());
		}
	}

}
