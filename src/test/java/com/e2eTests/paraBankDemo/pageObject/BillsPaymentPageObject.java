package com.e2eTests.paraBankDemo.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.e2eTests.paraBankDemo.utils.FakerDataGenerator;
import com.e2eTests.paraBankDemo.utils.TestsBase;

import lombok.Getter;

@Getter
public class BillsPaymentPageObject {
	
	@FindBy(how = How.XPATH, using = "//div[@id='leftPanel']//a[@href='billpay.htm']")
	private WebElement billPayLink;
	
	@FindBy(how = How.XPATH, using = "//div[@id='billpayForm']/h1[@class='title']")
	private WebElement pageTitle;

	@FindBy(how = How.NAME, using = "payee.name")
	private WebElement payeeNameInput;
	
	@FindBy(how = How.NAME, using = "payee.address.street")
	private WebElement payeeAddress;
	
	@FindBy(how = How.NAME, using = "payee.address.city")
	private WebElement payeeCity;
	
	@FindBy(how = How.NAME, using = "payee.address.state")
	private WebElement payeeState;
	
	@FindBy(how = How.NAME, using = "payee.address.zipCode")
	private WebElement payeeZip;
	
	@FindBy(how = How.NAME, using = "payee.phoneNumber")
	private WebElement payeePhone;
	
	@FindBy(how = How.NAME, using = "payee.accountNumber")
	private WebElement payeeAccountNum;
	
	@FindBy(how = How.NAME, using = "verifyAccount")
	private WebElement payeeAccountConfirm;
	
	@FindBy(how = How.NAME, using = "amount")
	private WebElement paymentAmount;
	
	@FindBy(how = How.NAME, using = "fromAccountId")
	private WebElement payerAccountId;
	
	@FindBy(how = How.XPATH, using = "//div[@id='billpayForm']//input[@value='Send Payment']")
	private WebElement confirmBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@id='billpayResult']/h1[@class='title']")
	private WebElement confirmMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='billpayForm']//span[@id='validationModel-verifyAccount-mismatch']")
	private WebElement idMismatchErrorMsg;

	
	public BillsPaymentPageObject() {
		PageFactory.initElements(TestsBase.getDriver(), this);
	}
	
	public void navigateToBillPayLink() {
		billPayLink.click();
	}
	
	public void performPaymentBillFill(String payeeAccount,String payeeAccountConf){
		
		payeeNameInput.sendKeys(FakerDataGenerator.getPayeename());
		payeeAddress.sendKeys(FakerDataGenerator.getPayeeaddress());
		payeeCity.sendKeys(FakerDataGenerator.getPayeecity());
		payeeState.sendKeys(FakerDataGenerator.getPayeestate());
		payeeZip.sendKeys(FakerDataGenerator.getPayeezip());
		payeePhone.sendKeys(FakerDataGenerator.getPayeephone());
		payeeAccountNum.sendKeys(payeeAccount);
		payeeAccountConfirm.sendKeys(payeeAccountConf);
		paymentAmount.sendKeys(FakerDataGenerator.getPaymentamount());
		Select payerAccountDD = new Select(payerAccountId);
		payerAccountDD.selectByIndex(0);;
	}
	
	public void confirmPayment() {
		confirmBtn.click();
	}

}
