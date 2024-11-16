package com.e2eTests.paraBankDemo.utils;

import java.util.Locale;
import com.github.javafaker.Faker;

public class FakerDataGenerator {

	private static final Faker faker = new Faker(Locale.US);

	private static final String firstName = faker.name().firstName();
	private static final String lasttName = faker.name().lastName();
	private static final String address = faker.address().streetAddress();
	private static final String city = faker.address().city();
	private static final String state = faker.address().state();
	private static final String zip = faker.address().zipCode();
	private static final String phone = faker.phoneNumber().cellPhone();
	private static final String ssn = faker.idNumber().ssnValid();
	private static final String userName = faker.name().username();
	private static final String password = faker.internet().password(6, 8, true);
	private static final String invalidPw = faker.internet().password();
	private static final String payeeName = faker.name().fullName();
	private static final String payeeAddress = faker.address().streetAddress();
	private static final String payeeCity = faker.address().city();
	private static final String payeeState = faker.address().state();
	private static final String payeeZip = faker.address().zipCode();
	private static final String payeePhone = faker.phoneNumber().cellPhone();
	private static final String payeeAccountId = faker.numerify("#####");
	private static final String MMpayeeAccountId = faker.numerify("#####");
	private static final String paymentAmount = faker.numerify("###");

	public static String getFirstname() {
		return firstName;
	}

	public static String getLasttname() {
		return lasttName;
	}

	public static String getAddress() {
		return address;
	}

	public static String getCity() {
		return city;
	}

	public static String getState() {
		return state;
	}

	public static String getZip() {
		return zip;
	}

	public static String getPhone() {
		return phone;
	}

	public static String getSsn() {
		return ssn;
	}

	public static String getPassword() {
		return password;
	}

	public static String getUsername() {
		return userName;
	}

	public static String getInvalidpw() {
		return invalidPw;
	}

	public static String getPayeename() {
		return payeeName;
	}

	public static String getPayeeaccountid() {
		return payeeAccountId;
	}

	public static String getPaymentamount() {
		return paymentAmount;
	}

	public static String getPayeeaddress() {
		return payeeAddress;
	}

	public static String getPayeecity() {
		return payeeCity;
	}

	public static String getPayeestate() {
		return payeeState;
	}

	public static String getPayeezip() {
		return payeeZip;
	}

	public static String getPayeephone() {
		return payeePhone;
	}

	public static String getMmpayeeaccountid() {
		return MMpayeeAccountId;
	}

}
