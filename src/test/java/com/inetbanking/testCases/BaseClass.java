package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.Readconfig;

public class BaseClass {
	
	Readconfig readConfig = new Readconfig();

	public String baseURL = readConfig.getApplicationURL();
	public String userName = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;

	public static Logger logger;

	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
    public void setUp(String br)
    {
		 
        logger = Logger.getLogger("eBanking");
        PropertyConfigurator.configure("Log4j.properties");
        
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
        
        if(br.equalsIgnoreCase("chrome"))
        {
		System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
	    driver = new ChromeDriver();
        }
        
        else if(br.equalsIgnoreCase("firefox"))
        {
		System.setProperty("webdriver.firefox.marionette", readConfig.getFirefoxpath());
        driver = new FirefoxDriver();
        }
        
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
        
       
    }
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
    
	
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	//to generate random-string
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);//this generates unique string with 8 Alphabets
		return generatedString;
	}
	
	
	//to generate random-number
	public static String randomNum()
	{
		String generatedStringNumber = RandomStringUtils.randomNumeric(4);//this generates unique numeric with 4 numbers
		return generatedStringNumber;
	}
    
    }

    





    