package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) throws  InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(uname);
		logger.info("UserName is provided");
		loginPage.setPassword(pwd);
		logger.info("Password is provided");
		loginPage.clickSubmit();

		Thread.sleep(3000);
		
		if(isAlertPresent())
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("Login Passed");
			loginPage.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	public boolean isAlertPresent() //user defined method
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			
			return false;
		}
		
	}

	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
	    String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testData\\LoginData.xlsx";
		
	    int rownum = XLUtils.getRowCount(path, "Sheet1");
	    int colcount = XLUtils.getCellCount(path, "Sheet1",1);
	    
	    String logindata[][] = new String[rownum][colcount];
	    
	    for(int i=1; i<=rownum; i++) //first row is header not actual data so ignore it, so start with 1
	    {
	    	for(int j=0; j<colcount; j++)
	    	{
	    		logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j); //0 0 //logindata[i-1][j] because array stores from 0 index so i-1
	    	}
	    }
	    return logindata;
	}


}
