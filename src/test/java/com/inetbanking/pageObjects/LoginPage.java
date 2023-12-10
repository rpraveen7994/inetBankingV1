package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	//https://demo.guru99.com/V4/index.php
//	System.setProperty("","");
	
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void setUserName(String uName) {
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String pWord) {
		txtPassword.sendKeys(pWord);
	}
	
	public void clickSubmit() {
        btnLogin.click(); 
	}
	
	public void clickLogout() {
		lnkLogout.click(); 
	}
	
	
}
