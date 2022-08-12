package com.testNG;

import org.testng.annotations.Test;

import com.pages.DropdownPage;
import com.pages.MultipleTabPage;
import com.utility.Constants;
import com.utility.Libraryfile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DropeDownValidation extends Libraryfile {
	
 //WebDriver driver;
	
  @Test (priority=0)
  public void ValidateDropdownPage () {
	  System.out.println("Validate DropDown Page");
	  driver.navigate().to(objProperties.getProperty("DropDownURL"));
		 driver.manage().timeouts().pageLoadTimeout(Constants.pageloadtimeout, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 String TitleofDropDownpage = driver.getTitle();
		 System.out.println("TitleofDropDownpage:"+TitleofDropDownpage);
		 Assert.assertEquals(TitleofDropDownpage, objProperties.getProperty("DropDownTitle"));

	  
  
  } 

  @Test(priority=1)
    public void ValidateDropDown() {
	  
	  System.out.println("Inside DROP DOWN");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	 
	  WebElement Element = driver.findElement(DropdownPage.CountryDropDown);
	  Element.click();
	  Select objSelect = new Select(Element);
	  objSelect.selectByValue("India");
	  
	  List<WebElement> Alloptions = objSelect.getOptions();
	  int size = Alloptions.size();
	  for(WebElement Country:Alloptions) {
		  
		  String CountryName = Country.getText();
		  System.out.println("Country name is :" +CountryName);
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
