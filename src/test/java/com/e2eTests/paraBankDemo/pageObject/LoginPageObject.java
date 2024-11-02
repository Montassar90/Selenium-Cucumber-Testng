package com.e2eTests.paraBankDemo.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.e2eTests.paraBankDemo.utils.TestsBase;

public class LoginPageObject {

	// Element representing the login panel area on the page
	@FindBy(how = How.ID, using = "loginPanel")
	private WebElement loginPanel;

	// Input field for entering the username
	@FindBy(how = How.NAME, using = "username")
	private WebElement userNameInput;

	// Input field for entering the password
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordInput;

	// Submit button for the login form
	@FindBy(how = How.XPATH, using = "//div[@class='login']/input[@type='submit']")
	private WebElement loginButton;

	// Title element displayed on the page after successful login
	@FindBy(how = How.XPATH, using = "//div[@id='showOverview']/h1[@class='title']")
	private WebElement pageTitle;

	// Welcome message displayed on the left panel after login
	@FindBy(how = How.XPATH, using = "//div[@id='leftPanel']//p[@class='smallText']")
	private WebElement welcomeMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='rightPanel']/p[@class='error']")
	private WebElement errorMsg;

	// Constructor to initialize elements using PageFactory
	public LoginPageObject() {
		PageFactory.initElements(TestsBase.getDriver(), this);
	}

	/**
	 * Method to fill in the login form with provided username and password. The
	 * "browser" system property is prefixed to the username and password as a test
	 * behavior.
	 *
	 * @param user     the username to input
	 * @param password the password to input
	 */
	public void performLoginFill(String user, String password) {
		String browser = System.getProperty("browser", "chrome");
		userNameInput.sendKeys(browser + user);
		passwordInput.sendKeys(browser + password);
	}

	/**
	 * Method to click the login button and submit the login form.
	 */
	public void submitLoginForm() {
		loginButton.click();
	}

	/**
	 * Retrieves the page title element for verification purposes.
	 * 
	 * @return WebElement representing the page title
	 */
	public WebElement getPageTitle() {
		return pageTitle;
	}

	/**
	 * Retrieves the welcome message element for verification purposes.
	 * 
	 * @return WebElement representing the welcome message
	 */
	public WebElement getWelcomeMsg() {
		return welcomeMsg;
	}

	/**
	 * Retrieves the login panel element for verification purposes.
	 * 
	 * @return WebElement representing the login panel
	 */
	public WebElement getLoginPanel() {
		return loginPanel;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	
	
}
