package com.e2eTests.paraBankDemo.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.paraBankDemo.utils.ConfigFileReader;
import com.e2eTests.paraBankDemo.utils.TestsBase;

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

	public ConfigFileReader configFileReader;

	// Constructor initializes WebElements and loads configuration file
	public RegistrationPageObject() {
		PageFactory.initElements(TestsBase.getDriver(), this);
		configFileReader = new ConfigFileReader();
	}

	// Method to navigate to the sign-up page by clicking on the "Register" link
	public void navigateToSignUp() {
		signUpLink.click();
	}

	// Method to fill out the registration form with data from configuration file
	public void performFormFill() {
		String browser = System.getProperty("browser","chrome"); // Retrieves the current browser property
		// Fill in each field in the registration form
		firstNameInput.sendKeys(configFileReader.getProperties("firstName"));
		lastNameInput.sendKeys(configFileReader.getProperties("lastName"));
		addressInput.sendKeys(configFileReader.getProperties("address"));
		cityInput.sendKeys(configFileReader.getProperties("city"));
		stateInput.sendKeys(configFileReader.getProperties("state"));
		zipCodeInput.sendKeys(configFileReader.getProperties("zip"));
		phoneInput.sendKeys(configFileReader.getProperties("phone"));
		ssnInput.sendKeys(configFileReader.getProperties("ssn"));
		userNameInput.sendKeys(browser + configFileReader.getProperties("userName")); // Username prefixed with browser
																						// name
		passwordInput.sendKeys(browser + configFileReader.getProperties("password")); // Password prefixed with browser
																						// name
		passwordConfirmInput.sendKeys(browser + configFileReader.getProperties("password"));
	}

	// Method to submit the registration form
	public void submitForm() {
		submitBtn.click();
	}

	// Method to retrieve the success message element after form submission
	public WebElement getSuccessMsg() {
		return successMsg;
	}
}
