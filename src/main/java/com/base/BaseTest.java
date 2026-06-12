package com.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.utilities.ConfigReader;

public class BaseTest {

    // ThreadLocal — each parallel thread gets its OWN driver!
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    // Log4j logger
    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    
    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
    	logger.info("Test started - Browser: "+ browser);
    	
    	WebDriver webDriver;
    	
    	if(browser.equalsIgnoreCase("chrome")) {
    		webDriver = new ChromeDriver();
    		logger.info("Chrome browser launched successfully");
    	} else if(browser.equalsIgnoreCase("firefox")) {
    		webDriver = new FirefoxDriver();
    		 logger.info("Firefox browser launched successfully");

        } else if (browser.equalsIgnoreCase("edge")) {
            webDriver = new EdgeDriver();
            logger.info("Edge browser launched successfully");

        } else {
            logger.warn("Unknown browser '" + browser + "' — defaulting to Chrome");
            webDriver = new ChromeDriver();
        }
    	
    	 // Store driver in ThreadLocal
    	driver.set(webDriver);
    	
    	getDriver().manage().window().maximize();
    	getDriver().manage().timeouts().implicitlyWait(
                Duration.ofSeconds(ConfigReader.getImplicitWait())
            );
            getDriver().get(ConfigReader.getURL());

            logger.info("Navigated to URL: " + ConfigReader.getURL());
        }

        // All classes use getDriver() — never use driver directly!
        public static WebDriver getDriver() {
            return driver.get();
        }

        @AfterMethod
        public void tearDown() {
            if (getDriver() != null) {
                getDriver().quit();
                driver.remove();
                logger.info("Browser closed and driver removed");
                logger.info("========================================");
            }
    }
}
