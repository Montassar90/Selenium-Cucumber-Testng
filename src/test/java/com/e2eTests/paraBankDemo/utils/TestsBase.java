package com.e2eTests.paraBankDemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestsBase {

    // Static WebDriver instance, shared across tests.
    private static WebDriver driver;
    private ConfigFileReader configFileReader = new ConfigFileReader(); // Reads configuration settings

    @Before
    public void setup() {
        // Gets the browser type from system properties, defaulting to "chrome"
        String browser = System.getProperty("browser", "chrome");
        
        // Initializes the WebDriver based on the specified browser
        driver = initializeDriver(browser);
        
        // Maximizes the browser window for better visibility during tests
        driver.manage().window().maximize();
        
        // Opens the base URL specified in the configuration file
        driver.get(configFileReader.getProperties("baseUrl"));
    }

    private WebDriver initializeDriver(String browser) {
        // Switch statement to select the WebDriver based on the browser type
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(); // Returns Chrome WebDriver instance
            case "firefox":
                return new FirefoxDriver(); // Returns Firefox WebDriver instance
            case "edge":
                return new EdgeDriver(); // Returns Edge WebDriver instance
            default:
                // Throws an exception if the browser type is not supported
                throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported");
        }
    }

   @After
    public void tearDown() {
        // Closes the WebDriver if it is still active
        if (driver != null) {
            driver.quit();
        }
    }

    // Returns the WebDriver instance to other classes if needed
    public static WebDriver getDriver() {
        return driver;
    }
}
