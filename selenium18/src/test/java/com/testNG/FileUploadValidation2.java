package com.testNG;

import org.testng.annotations.Test;

import com.pages.DownloadFilePage;
import com.pages.FileUploadPage;
import com.utility.Constants;
import com.utility.Libraryfile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FileUploadValidation2 extends Libraryfile {
	
  @Test (priority=0)
  public void ValidaeFileUploadPage () {
	  System.out.println("ValidateFileUploadPage");
	  driver.navigate().to(objProperties.getProperty("FileUpload"));
		 driver.manage().timeouts().pageLoadTimeout(Constants.pageloadtimeout, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 String TitleofFileUploadPage = driver.getTitle();
	 System.out.println("TitleofFileUploadPage:"+TitleofFileUploadPage);
		Assert.assertEquals(TitleofFileUploadPage,objProperties.getProperty("TiTleOfFileupload"));
  }

  
  
  @Test(priority=1)
  
  public void ValidateUpload() throws InterruptedException, AWTException {
	  System.out.println("Inside Upload File");
	 
	  
			//driver.findElement(FileUploadPage.FileUpload).sendKeys("C:\\Users\\Admin\\git\\repository\\selenium18\\src\\test\\resources\\Sample.jpg");
			
			//using robot class
			//driver.findElement(FileUploadPage.FileUpload).click();
			Actions objAction = new Actions(driver);
			  WebElement upload= driver.findElement(FileUploadPage.FileUpload);
			  objAction.click(upload).build().perform();
			  StringSelection SS= new StringSelection("C:\\Users\\Admin\\git\\repository\\selenium18\\src\\test\\resources\\samplefile.doc");

				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS,null);

				Robot rb = new Robot();
//				rb.delay(2000);
				//StringSelection SS= new StringSelection("C:\\Users\\Admin\\git\\repository\\selenium18\\src\\test\\resources\\Sample.jpg");
				
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				Thread.sleep(100);
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyPress(KeyEvent.VK_ENTER);
				
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
