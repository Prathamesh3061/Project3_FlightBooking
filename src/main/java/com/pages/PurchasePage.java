package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(PurchasePage.class);

//	Locators
	private By inputName = By.id("inputName");
    private By inputAddress     = By.id("address");
    private By inputCity        = By.id("city");
    private By inputState       = By.id("state");
    private By inputZipCode     = By.id("zipCode");
    private By inputCardNumber  = By.id("creditCardNumber");
    private By inputCardMonth   = By.id("creditCardMonth");
    private By inputCardYear    = By.id("creditCardYear");
    private By inputNameOnCard  = By.id("nameOnCard");
    private By purchaseBtn      = By.cssSelector("input.btn.btn-primary");
    private By checkBox = By.id("rememberMe");
    
    // constructor
    public PurchasePage(WebDriver driver) {
    	this.driver = driver;
    }
    
    public void enterPassengerDetails(String name, String address, String city, String state, String zip) {
    	driver.findElement(inputName).clear();
    	driver.findElement(inputName).sendKeys(name);
    	
    	driver.findElement(inputAddress).clear();
        driver.findElement(inputAddress).sendKeys(address);

        driver.findElement(inputCity).clear();
        driver.findElement(inputCity).sendKeys(city);

        driver.findElement(inputState).clear();
        driver.findElement(inputState).sendKeys(state);

        driver.findElement(inputZipCode).clear();
        driver.findElement(inputZipCode).sendKeys(zip);

        logger.info("Passenger details entered for: " + name);
    }
    
    public void enterCardDetails(String cardNumber, String month, String year, String nameOnCard) {
        driver.findElement(inputCardNumber).clear();
        driver.findElement(inputCardNumber).sendKeys(cardNumber);

        driver.findElement(inputCardMonth).clear();
        driver.findElement(inputCardMonth).sendKeys(month);

        driver.findElement(inputCardYear).clear();
        driver.findElement(inputCardYear).sendKeys(year);

        driver.findElement(inputNameOnCard).clear();
        driver.findElement(inputNameOnCard).sendKeys(nameOnCard);

        logger.info("Card details entered for: " + nameOnCard);
    }
    
    public void clickPurchase() {
        driver.findElement(purchaseBtn).click();
        logger.info("Clicked Purchase Flight button");
    }


}
