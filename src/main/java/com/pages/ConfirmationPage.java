package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(ConfirmationPage.class);
	
	
//	locators
    private By confirmationHeader = By.cssSelector("h1");
    private By bookingId          = By.xpath("//table/tbody/tr[1]/td[2]");
	
//	constructor
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getConfirmationHeader() {
		String header = driver.findElement(confirmationHeader).getText();
		logger.info("Confirmation header: " + header);
		return header;
	}
	
	public String getBookingId() {
		String id = driver.findElement(bookingId).getText();
        logger.info("Booking ID received: " + id);
        return id;
	}
	
	public boolean isBookingConfirmed() {
		boolean confirmed = getConfirmationHeader().contains("Thank you for your purchase");
        logger.info("Booking confirmed: " + confirmed);
        return confirmed;
	}
}
