package com.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReservePage {

	private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(ReservePage.class);

//    Locators
    private By pageHeader      = By.tagName("h1");
    private By firstFlightBtn  = By.xpath("//table/tbody/tr[1]/td[1]/input");

    // Constructor
    public ReservePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageLoaded() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
    	wait.until(ExpectedConditions.urlContains("reserve"));
    	
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: " + currentUrl);
    	
        boolean loaded = currentUrl.contains("reserve");
        logger.info("Reserve page loaded: " + loaded);
        return loaded;
    }

    public void selectFirstFlight() {
        driver.findElement(firstFlightBtn).click();
        logger.info("Selected first available flight");
    }
}
