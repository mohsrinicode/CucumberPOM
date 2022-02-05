package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver>  tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser value is : " + browser);
		
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		System.out.println("Hellow develop branch");
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	
	}
	
	public static WebDriver getDriver()
	{
		return tlDriver.get();
	}
}
