package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException { 
		
		logger.info("URL Opened");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(userName);
		logger.info("UserName is entered");
		
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}

}
