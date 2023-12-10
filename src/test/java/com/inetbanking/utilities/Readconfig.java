package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties prop;
	
	public Readconfig() {
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		
		
	}
	
	
	public String getApplicationURL()
	{
		String url = prop.getProperty("basURL");
		return url;
	}
	
	
	public String getUserName()
	{
		String userName = prop.getProperty("userName");
		return userName;
	}
	
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	
	public String getChromepath()
	{
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	
	public String getFirefoxpath()
	{
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}
}
