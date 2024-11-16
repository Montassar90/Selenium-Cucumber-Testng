package com.e2eTests.paraBankDemo.stepDefinition;

import static org.testng.Assert.assertEquals;

import com.e2eTests.paraBankDemo.pageObject.BillsPaymentPageObject;
import com.e2eTests.paraBankDemo.utils.BrowserUtils;
import com.e2eTests.paraBankDemo.utils.ConfigFileReader;
import com.e2eTests.paraBankDemo.utils.FakerDataGenerator;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BillPaymentStepDefinition {

	private BillsPaymentPageObject billsPaymentPageObject;
	private ConfigFileReader configFileReader;
	private BrowserUtils browserUtils;

	public BillPaymentStepDefinition() {
		billsPaymentPageObject = new BillsPaymentPageObject();
		configFileReader = new ConfigFileReader();
		browserUtils = new BrowserUtils();
	}

	@Then("I click on the bill pay link")
	public void iClickOnTheBillPayLink() {
		browserUtils.explicitVisibleWait(billsPaymentPageObject.getBillPayLink());
		browserUtils.explicitClickableWait(billsPaymentPageObject.getBillPayLink());
		billsPaymentPageObject.navigateToBillPayLink();
	}

	@Then("The bill payment service section should appears")
	public void theBillPaymentServiceSectionShouldAppears() {
		try {
			// Retrieves actual section title text and constructs expected message
			String actualMsg = billsPaymentPageObject.getPageTitle().getText();
			String expectedMsg = configFileReader.getProperties("billPaymentTitle");
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

	@When("I fill the form with valid data")
	public void iFillTheFormWithValidData() {
		billsPaymentPageObject.performPaymentBillFill(FakerDataGenerator.getPayeeaccountid(),
				FakerDataGenerator.getPayeeaccountid());
	}

	@When("I click on the confirm button")
	public void iClickOnTheConfirmButton() {
		billsPaymentPageObject.confirmPayment();
	}

	@Then("I should see a confirmation message of the payment process")
	public void iShouldSeeAConfirmationMessageOfThePaymentProcess() {
		try {
			browserUtils.explicitVisibleWait(billsPaymentPageObject.getConfirmMsg());
			// Retrieves the actual confirmation message text from the page
			String actualMsg = billsPaymentPageObject.getConfirmMsg().getText();
			// Gets the expected confirmation message from configuration properties
			String expectedMsg = configFileReader.getProperties("paymentConfirmMsg");

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

	@When("I fill the Verify Account field with data that does not match the ID field")
	public void iFillTheVerifyAccountfieldWithDataThatDoesNotMatchTheIdField() {
		billsPaymentPageObject.performPaymentBillFill(FakerDataGenerator.getPayeeaccountid(),
				FakerDataGenerator.getMmpayeeaccountid());

	}

	@Then("I should see a mismatch error message")
	public void iShouldSeeAMismatchErrorMessage() {
		try {
			browserUtils.explicitVisibleWait(billsPaymentPageObject.getIdMismatchErrorMsg());
			// Retrieves the actual confirmation message text from the page
			String actualMsg = billsPaymentPageObject.getIdMismatchErrorMsg().getText();
			// Gets the expected confirmation message from configuration properties
			String expectedMsg = configFileReader.getProperties("billIdErrorMsg");

			assertEquals(actualMsg, expectedMsg);
		} catch (NullPointerException e) {
			// Logs a message if confirmation message element is null
			System.err.println("Error message is not found or is null: " + e.getMessage());
		} catch (Exception e) {
			// Logs any unexpected errors
			System.err.println("An unexpected error occurred while verifying the error message: " + e.getMessage());
		}
	}

}
