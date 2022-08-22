package com.testNG;

import org.testng.annotations.Test;

import com.pages.DownloadFilePage;
import com.pages.WebTable;
import com.utility.Constants;
import com.utility.Libraryfile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FileDownloadValidaion extends Libraryfile {
	
  @Test (priority=0)
  public void ValidaeFileDownloadPage () {
	  System.out.println("ValidaeFileDownloadPage");
	  driver.navigate().to(objProperties.getProperty("FileDownload"));
		 driver.manage().timeouts().pageLoadTimeout(Constants.pageloadtimeout, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 String TitleofFileDownloadPage = driver.getTitle();
	 System.out.println("TitleofWebTablepage:"+TitleofFileDownloadPage);}
		//Assert.assertEquals(TitleofWebTablepage, objProperties.getProperty("MultipeWindowParentTitle"));

	  
  
  @Test(priority=1)
  public void ValidateFileDownload() throws InterruptedException {
	  System.out.println("Inside page download");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy, (0,300)");
	  driver.findElement(DownloadFilePage.Downloadlink).click();
	  
	  Thread.sleep(8000);
		File objFile = new File(System.getProperty("user.dir"));
		File[] AllFiles = objFile.listFiles();
		for(File IndividualFile:AllFiles) {
			String FileName = IndividualFile.getName();
			System.out.println("FileName:"+FileName);
			Boolean fileFound = false;
			if(FileName.contains(objProperties.getProperty("TypeOfDownloadedFile"))) {
				fileFound=true;
				Assert.assertTrue(fileFound, "File Downloaded is Not Validated");
				//IndividualFile.deleteOnExit();
			}
		}
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
