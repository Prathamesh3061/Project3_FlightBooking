package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	
	static{
		try {
			String path = "src/main/resources/config.properties";
			FileInputStream fis = new FileInputStream(path);
			properties = new Properties();
			properties.load(fis);
			fis.close();
		}catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties file not found!");
			
		}
	}
	
	
	public static String get(String key) {
		return properties.getProperty(key);
	}
	
    public static String getURL()             { return properties.getProperty("url"); }
    public static String getBrowser()         { return properties.getProperty("browser"); }
    public static String getDepartureCity()   { return properties.getProperty("departure.city"); }
    public static String getDestinationCity() { return properties.getProperty("destination.city"); }
    public static String getPassengerName()   { return properties.getProperty("passenger.name"); }
    public static String getAddress()         { return properties.getProperty("passenger.address"); }
    public static String getCity()            { return properties.getProperty("passenger.city"); }
    public static String getState()           { return properties.getProperty("passenger.state"); }
    public static String getZipCode()         { return properties.getProperty("passenger.zipcode"); }
    public static String getCardNumber()      { return properties.getProperty("passenger.cardnumber"); }
    public static String getCardMonth()       { return properties.getProperty("passenger.cardmonth"); }
    public static String getCardYear()        { return properties.getProperty("passenger.cardyear"); }
    public static String getCardHolder()      { return properties.getProperty("passenger.cardholder"); }
    public static int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicit.wait"));
    }		
	
}
