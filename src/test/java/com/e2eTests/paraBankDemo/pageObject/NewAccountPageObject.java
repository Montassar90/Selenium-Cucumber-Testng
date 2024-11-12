package com.e2eTests.paraBankDemo.pageObject;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.e2eTests.paraBankDemo.utils.TestsBase;

public class NewAccountPageObject {
	// Web element for the 'Open New Account' link on the left panel
	@FindBy(how = How.XPATH, using = "//div[@id='leftPanel']//a[@href='openaccount.htm']")
	private WebElement newAccountLink;

	// Web element for the page title in the 'Open Account' form
	@FindBy(how = How.XPATH, using = "//div[@id='openAccountForm']/h1[@class='title']")
	private WebElement pageTitle;

	// Dropdown element for selecting the account type
	@FindBy(how = How.XPATH, using = "//div[@id='openAccountForm']/form/select[@id='type']")
	private WebElement typeDD;

	// Button element to confirm opening a new account
	@FindBy(how = How.XPATH, using = "//div[@id='openAccountForm']//input[@value='Open New Account']")
	private WebElement newAccountBtn;

	// Web element for the confirmation message displayed after creating a new
	// account
	@FindBy(how = How.XPATH, using = "//div[@id='openAccountResult']//p")
	private WebElement newAccountConfirmMsg;

	// Constructor to initialize web elements with PageFactory
	public NewAccountPageObject() {
		PageFactory.initElements(TestsBase.getDriver(), this);
	}

	// Method to navigate to the 'Open New Account' page by clicking the link
	public void navigateToNewAccountLink() {
		WebDriverWait wait = new WebDriverWait(TestsBase.getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(newAccountLink));
		wait.until(ExpectedConditions.elementToBeClickable(newAccountLink));

		newAccountLink.click();
	}

	// Method to select an account type from the dropdown list
	public void selectAccountType(String type) {
		Select accountDD = new Select(typeDD);
		accountDD.selectByVisibleText(type);

	}

	// Method to click the 'Open New Account' button with an explicit wait for it to
	// be clickable
	public void clickOnOpenNewAccountBtn() {
		WebDriverWait wait = new WebDriverWait(TestsBase.getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(newAccountBtn));
		wait.until(ExpectedConditions.elementToBeClickable(newAccountBtn));
		newAccountBtn.click();
	}

	// Method to get the title element of the page
	public WebElement getPageTitle() {
		return pageTitle;
	}

	// Method to get the confirmation message after creating a new account with an
	// explicit wait
	public WebElement getNewAccountConfirmMsg() {
		WebDriverWait wait = new WebDriverWait(TestsBase.getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(newAccountConfirmMsg));
		return newAccountConfirmMsg;
	}

}
