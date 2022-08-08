package com.testNG;

import org.testng.annotations.Test;

import com.utility.Constants;
import com.utility.Frames1;
import com.utility.Libraryfile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class ValidateCherCherFrames extends Libraryfile {
	
	@Test(priority=1)
	public void ValidateFramesPageLoadedSuccessfully() {
		System.out.println("inside ValidateFramesPageLoadedSuccessfully");
		driver.get(objProperties.getProperty("FramesURL"));
		String TitleoFFramesPage = driver.getTitle();
		Assert.assertEquals(TitleoFFramesPage,objProperties.getProperty("FramesTitle") ,"Title oF FramesPage is not validtaed");
	}
	
	@Test (priority=2)
	
	public void ValidateFrame() {
		
		System.out.println("inside ValidateSingleFrameAvailable");
			driver.switchTo().frame(Frames1.OutsideFrame);
		WebElement frameElementInnerFrame = driver.findElement(Frames1.InnerFrame);
		driver.switchTo().frame(frameElementInnerFrame);
		driver.findElement(Frames1.InsideInnerFrame).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(Frames1.OutsideFrame);
		driver.findElement(Frames1.InsideOuterFrame).sendKeys(objProperties.getProperty("OuterFrametextbox"));

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
