package com.e2eTests.paraBankDemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestsBase {

	private static WebDriver driver;
	private ConfigFileReader configFileReader = new ConfigFileReader();

	@Before

	public void setup() {
		String browser = System.clearProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(configFileReader.getProperties("baseUrl"));
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(configFileReader.getProperties("baseUrl"));
			break;
		case "edge":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(configFileReader.getProperties("baseUrl"));
			break;

		default:
			throw new IllegalArgumentException("Browser \"" + browser + "\"is not supported");
		}
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
