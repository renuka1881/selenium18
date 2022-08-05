package com.testNG;

import org.testng.annotations.Test;

import com.utility.Constants;
import com.utility.Libraryfile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

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

public class ValidateAlerts extends Libraryfile {
	
 //WebDriver driver;
	
  @Test (priority=0)
  public void ValidateAlertpageLoad () {
	  System.out.println("ValidateAlertpageLoad");
	  driver.navigate().to(objProperties.getProperty("AlertUrl"));
		 driver.manage().timeouts().pageLoadTimeout(Constants.pageloadtimeout, TimeUnit.SECONDS);
		 String TitleofAlertPage = driver.getTitle();
		 System.out.println("titleOfAlertsPage:"+TitleofAlertPage);
		 Assert.assertEquals(TitleofAlertPage, objProperties.getProperty("TitleOFAlertsPage"));

	  
  
  }
@Test(priority=1)
public void ValidateDifferentAlerts() {
	System.out.println(" inside validate different Alerts");
	driver.findElement(By.name("alert")).click();
	ExplicitWaitfoAlertIsPresent();
	try {
		Thread.sleep(3500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Alert objAlert = driver.switchTo().alert();
	  String AlertMessage = objAlert.getText();
	  System.out.println("AlertMessage:"+AlertMessage);
	  Assert.assertEquals(AlertMessage,  objProperties.getProperty("AlertPopUpText"));
	  objAlert.accept();
	  
	  
	  driver.findElement(By.name("confirmation")).click();
	  ExplicitWaitfoAlertIsPresent();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  Alert objConfirmAlert = driver.switchTo().alert();
	  String ConfirmAlertMessage = objConfirmAlert.getText();
	  System.out.println(" Alert message"+ConfirmAlertMessage);
	  Assert.assertEquals(ConfirmAlertMessage, objProperties.getProperty("ConfirmAlertMessage"));
	objConfirmAlert.dismiss();
	
	
	driver.findElement(By.name("prompt")).click();
	  ExplicitWaitfoAlertIsPresent();
	  Alert PromptAlert =driver.switchTo().alert();
	  PromptAlert.sendKeys(objProperties.getProperty(ConfirmAlertMessage));

	
	
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
