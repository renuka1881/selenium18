package com.testNG;

import org.testng.annotations.Test;

import com.pages.DownloadFilePage;
import com.pages.FileUploadPage;
import com.pages.WebTable;
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

public class FileUploadValidation extends Libraryfile {
	
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
  
  public void ValidateUpload() {
	  System.out.println("Inside Upload File");
	  Actions objAction = new Actions(driver);
	  WebElement upload= driver.findElement(FileUploadPage.FileUpload);
	  objAction.click(upload).build().perform();
	  File objFile = new File(System.getProperty("user.dir")+"//src//test//resources//samplefile.doc");
	 
	  StringSelection objStringSelection = new StringSelection(objFile.toString());//used for data transfer
		//to convert path in string

//Clipboard is used for getting the system clipboard
Clipboard objClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//setcontents is used for setting the content of the clipboard to the objStringSelection path 
objClipboard.setContents(objStringSelection, null);

//Defines the interface for classes that can be used to provide data for a transfer operation. 
Transferable objTransferable = objClipboard.getContents(null);
if (objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
	try {
		System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

try {
	Thread.sleep(6000);
	Robot objRobot = new Robot();
	objRobot.keyPress(KeyEvent.VK_ENTER);
	objRobot.keyRelease(KeyEvent.VK_ENTER);
//		objRobot.wait(350);
	objRobot.keyPress(KeyEvent.VK_CONTROL);
	objRobot.keyPress(KeyEvent.VK_V);
//	objRobot.wait(350);
	objRobot.keyRelease(KeyEvent.VK_CONTROL);
	objRobot.keyRelease(KeyEvent.VK_V);
//	objRobot.wait(2500);
	Thread.sleep(6000);
	objRobot.keyPress(KeyEvent.VK_ENTER);
	objRobot.keyRelease(KeyEvent.VK_ENTER);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
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
