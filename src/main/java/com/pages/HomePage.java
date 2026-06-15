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
    
//    public void clickFindFlights() {
//    	driver.findElement(findFlightsBtn);
//    	logger.info("clicked find flights button");
//    }
    
    public void clickFindFlights() {
        java.util.List<org.openqa.selenium.WebElement> btns = driver.findElements(findFlightsBtn);
        logger.info("Number of elements matching findFlightsBtn locator: " + btns.size());
        for (org.openqa.selenium.WebElement el : btns) {
            logger.info("Found element -> tag: " + el.getTagName() + ", text: '" + el.getText() + "', value: " + el.getAttribute("value"));
        }
        driver.findElement(findFlightsBtn).click();
        logger.info("Clicked Find Flights button. Current URL after click: " + driver.getCurrentUrl());
    }
    
    // One method to do all steps together
    public void searchFlight(String from, String to) {
        logger.info("Starting flight search: " + from + " → " + to);
        selectDepartureCity(from);
        selectDestinationCity(to);
        clickFindFlights();
    }
	
}
