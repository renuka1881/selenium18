package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Libraryfile {
	public static Properties objProperties;
	public static WebDriver driver;

public  void ReadPropertyfile()  {
	System.out.println("location of project:" + System.getProperty("user.dir"));
	File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//config.properties");
	FileInputStream ObjInputStream;
	try {
		ObjInputStream = new FileInputStream(objFile);
		objProperties = new Properties();	
		objProperties.load(ObjInputStream);
		System.out.println(objProperties.getProperty("Browser"));
		System.out.println(objProperties.getProperty("Flipkart"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void launchbrowser() {
	String browserinfo = objProperties.getProperty("Browser");
	switch(browserinfo) {
	case "Chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	case "IE":
		WebDriverManager.iedriver().setup();
		driver =new InternetExplorerDriver();
		break;
	}
	//driver.get(objProperties.getProperty("GmoOnlineURL"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}
		
	public static void ExplicitWaitfoAlertIsPresent() {
		WebDriverWait wait =new WebDriverWait(driver,Constants.ExplicitWait);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	}

	
	
	
	
	
	



