package com.e2eTests.paraBankDemo.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.paraBankDemo.utils.FakerDataGenerator;
import com.e2eTests.paraBankDemo.utils.TestsBase;
import lombok.Getter;

@Getter
public class RegistrationPageObject {
	// Locate the "Register" link in the login panel
	@FindBy(how = How.XPATH, using = "//div[@id='loginPanel']//a[text()='Register']")
	private WebElement signUpLink;

	// Input fields for user registration form
	@FindBy(how = How.ID, using = "customer.firstName")
	private WebElement firstNameInput;

	@FindBy(how = How.ID, using = "customer.lastName")
	private WebElement lastNameInput;

	@FindBy(how = How.ID, using = "customer.address.street")
	private WebElement addressInput;

	@FindBy(how = How.ID, using = "customer.address.city")
	private WebElement cityInput;

	@FindBy(how = How.ID, using = "customer.address.state")
	private WebElement stateInput;

	@FindBy(how = How.ID, using = "customer.address.zipCode")
	private WebElement zipCodeInput;

	@FindBy(how = How.ID, using = "customer.phoneNumber")
	private WebElement phoneInput;

	@FindBy(how = How.ID, using = "customer.ssn")
	private WebElement ssnInput;

	@FindBy(how = How.ID, using = "customer.username")
	private WebElement userNameInput;

	@FindBy(how = How.ID, using = "customer.password")
	private WebElement passwordInput;

	@FindBy(how = How.ID, using = "repeatedPassword")
	private WebElement passwordConfirmInput;

	// Button to submit the registration form
	@FindBy(how = How.XPATH, using = "//div[@id='rightPanel']//input[@type='submit']")
	private WebElement submitBtn;

	// Element to display a success message after registration
	@FindBy(how = How.XPATH, using = "//div[@id='rightPanel']/p")
	private WebElement successMsg;

	@FindBy(how = How.ID, using = "customer.username.errors")
	private WebElement userNameError;


	// Constructor initializes WebElements
	public RegistrationPageObject() {
		PageFactory.initElements(TestsBase.getDriver(), this);
	}

	// Method to navigate to the sign-up page by clicking on the "Register" link
	public void navigateToSignUp() {
		signUpLink.click();
	}

	// Method to fill out the registration form with data from generated Fake data 
	public void performFormFill() {
		// Fill in each field in the registration form
		firstNameInput.sendKeys(FakerDataGenerator.getFirstname());
		lastNameInput.sendKeys(FakerDataGenerator.getLasttname());
		addressInput.sendKeys(FakerDataGenerator.getAddress());
		cityInput.sendKeys(FakerDataGenerator.getCity());
		stateInput.sendKeys(FakerDataGenerator.getState());
		zipCodeInput.sendKeys(FakerDataGenerator.getZip());
		phoneInput.sendKeys(FakerDataGenerator.getPhone());
		ssnInput.sendKeys(FakerDataGenerator.getSsn());
		userNameInput.sendKeys(FakerDataGenerator.getUsername());  																			
		passwordInput.sendKeys(FakerDataGenerator.getPassword()); 
		passwordConfirmInput.sendKeys(FakerDataGenerator.getPassword());
	}

	// Method to submit the registration form
	public void submitForm() {
		submitBtn.click();
	}

}
