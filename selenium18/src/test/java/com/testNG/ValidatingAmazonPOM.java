package com.testNG;

import org.testng.annotations.Test;

import com.utility.Amazonlocators;
import com.utility.Constants;
import com.utility.Libraryfile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidatingAmazonPOM extends Libraryfile {
	
 //WebDriver driver;
	
  @Test (priority=0)
  public void ValidateAmazonPOM () {
	  System.out.println("Validate Amazon");
	  driver.get(objProperties.getProperty("AmazonURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
	  String titleofAmazon = driver.getTitle();
	  System.out.println("titleOfAmazon:"+titleofAmazon);
Assert.assertEquals(titleofAmazon, objProperties.getProperty("AmazonTitle"));
  
  }
 
	
  @Test (priority=1)
  public void sendproductname() throws InterruptedException {
	  
	  //sending backpack value in serach box
	  driver.findElement(Amazonlocators.HomeSearch).sendKeys("Backpack");
	  Thread.sleep(3500);
	//clicking search icon to find backpack results
	  driver.findElement(Amazonlocators.Backpacksearch).click();

	
	
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
