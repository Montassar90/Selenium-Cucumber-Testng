package com.e2eTests.paraBankDemo.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2eTests.paraBankDemo.utils.TestsBase;

public class NewAccountPageObject {

	
	@FindBy(how = How.XPATH, using = "//div[@id='leftPanel']//a[@href='openaccount.htm']")
	private WebElement newAccountLink;
	
	@FindBy(how = How.XPATH, using = "//div[@id='openAccountForm']/h1[@class='title']")
	private WebElement pageTitle;
	
	
	public NewAccountPageObject() {
		PageFactory.initElements(TestsBase.getDriver(), this);
	}
	
	public void navigateToNewAccountLink() {
		newAccountLink.click();
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}



}
