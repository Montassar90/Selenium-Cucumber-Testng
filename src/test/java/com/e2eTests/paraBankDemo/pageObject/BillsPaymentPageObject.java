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
	
	public void performPayeeInfoFill(){
		payeeNameInput.clear();
		payeeNameInput.sendKeys(FakerDataGenerator.getPayeename());
		payeeAddress.clear();
		payeeAddress.sendKeys(FakerDataGenerator.getPayeeaddress());
		payeeCity.clear();
		payeeCity.sendKeys(FakerDataGenerator.getPayeecity());
		payeeState.clear();
		payeeState.sendKeys(FakerDataGenerator.getPayeestate());
		payeeZip.clear();
		payeeZip.sendKeys(FakerDataGenerator.getPayeezip());
		payeePhone.clear();
		payeePhone.sendKeys(FakerDataGenerator.getPayeephone());
	}
	public void performPayeeAccountInfoFill(String payeeAccount,String payeeAccountConf) {
		payeeAccountNum.clear();
		payeeAccountNum.sendKeys(payeeAccount);
		payeeAccountConfirm.clear();
		payeeAccountConfirm.sendKeys(payeeAccountConf);
		paymentAmount.clear();
		paymentAmount.sendKeys(FakerDataGenerator.getPaymentamount());
	}
	public void selectPayerAccount() {
		Select payerAccountDD = new Select(payerAccountId);
		payerAccountDD.selectByIndex(0);;
	}
	
	public void confirmPayment() {
		confirmBtn.click();
	}

}
