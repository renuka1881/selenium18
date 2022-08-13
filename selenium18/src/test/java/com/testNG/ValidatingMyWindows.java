package com.testNG;

import org.testng.annotations.Test;

import com.pages.MultipleTabPage;
import com.utility.Constants;
import com.utility.Libraryfile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingMyWindows extends Libraryfile {
	
 //WebDriver driver;
	
  @Test (priority=0)
  public void ValidateMultipleWindow () {
	  System.out.println("Validate Multiple windows");
	  driver.navigate().to(objProperties.getProperty("MultipleWindowsURL"));
		 driver.manage().timeouts().pageLoadTimeout(Constants.pageloadtimeout, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 String TitleofparentWindow = driver.getTitle();
		 System.out.println("TitleofparentWindow:"+TitleofparentWindow);
		 Assert.assertEquals(TitleofparentWindow, objProperties.getProperty("MultipeWindowParentTitle"));

	  
  
  } 

@Test (priority=1)
	public void ValidateNewBrowserWindow() {
	String ParentWindow = driver.getWindowHandle();
		driver.findElement(MultipleTabPage.NewTab).click();
	Set<String> Allwindows = driver.getWindowHandles();
	for (String IndiviualWindow : Allwindows){ 
		driver.switchTo().window(IndiviualWindow);
		String Title = driver.getTitle();
		System.out.println("Title of Window:"+Title);
		if(Title.equalsIgnoreCase(objProperties.getProperty("newBrowserWindowTitle"))) {
		String NewTabText =	driver.findElement(MultipleTabPage.NewBrowserText). getText();
		System.out.println("New Tab text"+NewTabText);
		Assert.assertEquals(NewTabText,objProperties.getProperty("NewTabTexts") );
		driver.close();
		}
		
	}
	driver.switchTo().window(ParentWindow);
		
		}
		
		
	
	


  
  @BeforeMethod
  public void beforeMethod() {
	 
	  System.out.println("before method");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
	  launchbrowser();

  }

  
@AfterTest
  public void afterTest() {
	  System.out.println("after test");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
	  try {
		ReadPropertyfile();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite");

  }

}
