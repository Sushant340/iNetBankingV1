package com.iNetBankingV1.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.loginPage;
import com.iNetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class loginPage_01 extends baseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		loginPage lp=new loginPage(driver);
		lp.setUserName(user);
		//logger.info("user name provided");
		lp.setPassword(pwd);
		//logger.info("password provided");
		lp.clickSubmit();
	
	Thread.sleep(3000);
	if(isAlertPresent()==true)  
	{
		
		driver.switchTo().alert().accept();//close the alert
	//	logger.info("password provided");
		driver.switchTo().defaultContent();//
		Assert.assertTrue(false);
		//logger.warning("Login failed");
	}

	else
	{
		Assert.assertTrue(true);
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
}
	
	
	
	
	//user defined method created to check if alert is present or not
	
	public boolean isAlertPresent()
	{
		
		//if the alert is not present it will throw an exception ,
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
			}
		}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/iNetBanking/testData/LoginData.xlsx";
		
		//to count number of rows and columns
		int rownum=XLUtils.getRowCount(path, "Sheet1"); //row number
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		//to get the data
		
		for(int i=1;i<=rownum;i++) // number of rows
		{
			for (int j=0;j<colcount;j++)
			// every column for that particular row
		
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
	

	
}