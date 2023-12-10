package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
         
	 @Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		
		addCust.clickAddNewCustomer();
		
		logger.info("Providing Customer details.....");
		
		addCust.custName("Laxman");
		addCust.custGender("male");
		addCust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addCust.custaddress("INDIA");
		addCust.custcity("HYD");
		addCust.custstate("AP");
		addCust.custpinno("500074");
		addCust.custtelephoneno("9878980025415");
		
		String email = randomString() + "@gmail.com"; 
		
		addCust.custemailid(email);
		addCust.custpassword("abcdef");
		addCust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation Started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res)
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed.....");
		}
		else
		{
			logger.info("Test Case Failed.....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	

}
