package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	
	private WebDriver driver;
	
	//1.By Locators
	
	private By email=By.id("email");
	private By password = By.id("passwd");
	private By signinButton = By.id("SubmitLogin");
	private By forgotlink = By.linkText("Forgot your password?");
	//Constructor
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public String getLoginPageTitle()
	{
	 return	driver.getTitle();
		 
	}
	
	public boolean isforgotpwdLinkExsist()
	{
	return	driver.findElement(forgotlink).isDisplayed();
		
	}
	
	public void enterusername(String username)
	{
		driver.findElement(email).sendKeys(username);
	}
	
	public void enterpassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnlogin()
	{
		driver.findElement(signinButton).click();
	}
	public AccountPages doLogin(String un,String pwd)
	{
		System.out.println("Username---------->"+un+"password------>"+pwd) ;
		driver.findElement(email).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signinButton).click();
		return new AccountPages(driver);
		
	}
}
