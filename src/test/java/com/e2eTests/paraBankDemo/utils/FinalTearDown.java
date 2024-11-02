package com.e2eTests.paraBankDemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.AfterAll;

public class FinalTearDown {
	// Create a static instance of ConfigFileReader to read configuration properties
	private static ConfigFileReader configFileReader = new ConfigFileReader();

	// The method annotated with @AfterAll will execute after all tests are complete
	@AfterAll
	public static void resetDatabaseAfterAllTests() {
		// Initialize a new instance of the Chrome WebDriver
		WebDriver driver = new ChromeDriver();
		try {
			// Open the admin URL from the configuration file to access the reset database
			// page
			driver.get(configFileReader.getProperties("adminUrl"));

			// Locate the "Clean DB" button using XPath
			WebElement cleanDbButton = driver
					.findElement(By.xpath("//form[@name='initializeDB']//button[@name='action' and @value='CLEAN']"));

			// Click on the "Clean DB" button to reset the database
			cleanDbButton.click();
		} finally {
			// Close the WebDriver to end the browser session
			driver.quit();
		}
	}
}
