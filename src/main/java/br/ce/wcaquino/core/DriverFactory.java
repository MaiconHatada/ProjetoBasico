package br.ce.wcaquino.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	protected static WebDriver driver;
	public DriverFactory() {}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			switch (Propriedades.browser) {
			case FIREFOX: driver = new FirefoxDriver(); break;
			case CHROME: driver = new ChromeDriver(); break;
				
		
			}
		
		driver.manage().window().setSize(new Dimension(1000, 765));
		
		}
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null)
			
			driver.quit();
			driver = null;
	}


}
