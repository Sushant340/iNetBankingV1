package com.iNetBankingV1.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBanking.utilities.ReadConfig;

public class baseClass {

	
		ReadConfig readconfig=new ReadConfig();
		
		
	//public String baseURL="https://demo.guru99.com/v4/";
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassowrd();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br)
	
	{
		
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
	
		
		/*
		 * Logger logger=Logger.getLogger("ebanking"); // to get the logs of the
		 * execution PropertyConfigurator.configure("log4j.properties");
		 */
		 
		
		   //logger should be in base class.It should have been here but copying this to loginPage_00 test case as testcase is not executing if it is kept here*/
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
	
		driver=new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
	
		driver=new FirefoxDriver();
		}
		else if (br.equals("ie"))
		{
		System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
	
		driver=new EdgeDriver();
		
	
	}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	  @AfterClass 
	  public void teardown()
	  
	  { 
		  driver.quit();
	  
	  }
	  
	  
	  public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
		}
	  protected String randomestring() {
			// TODO Auto-generated method stub
			
			String generatedString=RandomStringUtils.randomAlphabetic(8);
			return(generatedString);
		
		     }
		
		private String randomeNum() {
			// TODO Auto-generated method stub
			
			String generatedString2=RandomStringUtils.randomNumeric(4);
			return(generatedString2);
			
		     }
}
