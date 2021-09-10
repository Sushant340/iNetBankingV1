package com.iNetBankingV1.testCases;

import java.io.IOException;
import java.util.logging.Logger;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.loginPage;

public class loginPage_00 extends baseClass{
	 
	@Test
	public void loginTest() throws IOException
	
	{
		
		
		/*
		 * // to handle SSL Certificate in chrome ChromeOptions handlingSSL = new
		 * ChromeOptions();
		 * 
		 * //Using the accept insecure cert method with true as parameter to accept the
		 * untrusted certificate handlingSSL.setAcceptInsecureCerts(true);
		 * 
		 * //Creating instance of Chrome driver by passing reference of ChromeOptions
		 * object WebDriver driver = new ChromeDriver(handlingSSL);
		 */
		 
		//Logger logger=Logger.getLogger("ebanking"); // to get the logs of the execution
		 //PropertyComparator.configure("log4j.properties");
		 
		driver.get(baseURL);	
		 //logger.info("URL is opened");
		
		
		 
		
		  
		  
	
	loginPage lp=new loginPage(driver);
	
	lp.setUserName(username);
	//logger.info("username is entered");
	
	lp.setPassword(password);
	//logger.info("password is entered");
	
	lp.clickSubmit();
	//logger.info("login is successful");
	
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage1234"))
		
	{
		Assert.assertTrue(true);
		//logger.info("login test passed");
	}
	else
	{	captureScreen(driver,"loginTest");
		Assert.assertFalse(false);
		//logger.info("login test failed");
	}
	
	}
}
