package com.e2eTests.paraBankDemo.utils;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    /**
     * Waits explicitly until the given element is visible on the page.
     * 
     * @param element the WebElement to wait for
     * @return the visible WebElement once it appears
     */
    public WebElement explicitVisibleWait(WebElement element) {
        // Create a WebDriverWait instance with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(TestsBase.getDriver(), Duration.ofSeconds(30));
        // Wait until the specified element is visible and return it
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits explicitly until the given element is clickable on the page.
     * 
     * @param element the WebElement to wait for
     * @return the clickable WebElement once it is ready to be clicked
     */
    public WebElement explicitClickableWait(WebElement element) {
        // Create a WebDriverWait instance with a timeout of 30 seconds
        WebDriverWait wait = new WebDriverWait(TestsBase.getDriver(), Duration.ofSeconds(30));
        // Wait until the specified element is clickable and return it
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
