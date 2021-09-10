package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro; // Properties is a class in java
	
	public ReadConfig() // constructor
	{
		File src=new File("./Configurations/config.properties");  //creating object for File class , src is a variable to store 
		
		try
		{
		FileInputStream fis=new	FileInputStream(src);
		pro=new Properties();//pro is the object of properties class
		pro.load(fis); // load method will load the complete config.properties file
		
		}
		catch(Exception e)
		{
			System.out.print("Exception is" +e.getMessage());
		}
	}

	//methods 
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}

	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassowrd()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEPath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	
	
	
	
}
