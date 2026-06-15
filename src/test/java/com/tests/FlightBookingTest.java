package com.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.ConfirmationPage;
import com.pages.HomePage;
import com.pages.PurchasePage;
import com.pages.ReservePage;
import com.utilities.ConfigReader;

public class FlightBookingTest extends BaseTest {

	  private static final Logger logger = LogManager.getLogger(FlightBookingTest.class);

	  @Test(priority = 1)
	  public void testFLightBookingEndToEnd() {
		  
		  logger.info("TC01: Flight Booking End-to-End");
		  
//		  Step 1- home page : search flight
		  HomePage homePage = new HomePage(getDriver());
		  homePage.searchFlight(ConfigReader.getDepartureCity(), ConfigReader.getDestinationCity());
	
//		  step 2 - Reserve the page: select the first flight
		  ReservePage reservePage = new ReservePage(getDriver());
		  Assert.assertTrue(reservePage.isPageLoaded(), "Reserve page did not load!");
		  reservePage.selectFirstFlight();
		  
//		  step 3- purchase page : enter passanger + card details
		  PurchasePage purchasePage = new PurchasePage(getDriver());
		  purchasePage.enterPassengerDetails(
				  ConfigReader.getPassengerName(),
				  ConfigReader.getAddress(),
	              ConfigReader.getCity(),
	              ConfigReader.getState(),
	              ConfigReader.getZipCode()
				  );
		  
		  purchasePage.enterCardDetails(
	                ConfigReader.getCardNumber(),
	                ConfigReader.getCardMonth(),
	                ConfigReader.getCardYear(),
	                ConfigReader.getCardHolder()
	                );
		  
		  purchasePage.clickPurchase();
		  
//		  step 4 - confirmation page verify booking
		  ConfirmationPage confirmationPage = new ConfirmationPage(getDriver());
		  Assert.assertTrue(confirmationPage.isBookingConfirmed(),"Booking was not Confirmed!");
		  
		  String bookingId = confirmationPage.getBookingId();
	      logger.info("Booking completed successfully! Booking ID: " + bookingId);

	       logger.info("TC01 PASSED");
		  
	  }
}
