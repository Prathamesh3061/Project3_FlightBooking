package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	

    // Locators
    private By departureCity   = By.name("fromPort");
    private By destinationCity = By.name("toPort");
    private By findFlightsBtn  = By.cssSelector("input.btn.btn-primary");
    
    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    public void selectDepartureCity(String city) {
    	Select select = new Select(driver.findElement(departureCity));
    	select.selectByVisibleText(city);
    	logger.info("Departure city selected: "+city);
    }
    
    public void selectDestinationCity(String city) {
    	Select select = new Select(driver.findElement(destinationCity));
    	select.selectByVisibleText(city);
    	logger.info("Destination city selected: "+city);
    }
    
    public void clickFindFlights() {
    	driver.findElement(findFlightsBtn);
    	logger.info("clicked find flights button");
    }
	
}
