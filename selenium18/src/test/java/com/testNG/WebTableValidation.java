package com.testNG;

import org.testng.annotations.Test;

import com.pages.WebTable;
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

public class WebTableValidation extends Libraryfile {
	
  @Test (priority=0)
  public void ValidateWebpage () {
	  System.out.println("Validate WebTable page");
	  driver.navigate().to(objProperties.getProperty("WebTableURL"));
		 driver.manage().timeouts().pageLoadTimeout(Constants.pageloadtimeout, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 String TitleofWebTablepage = driver.getTitle();
		 String PageSource = driver.getPageSource();
		 System.out.println("PageSource:"+PageSource);
		 if(PageSource.contains("Web Table")) {
			Assert.assertTrue(true);		 
		 
		}
		
  }
	  
  
  

@Test(priority = 1)
public void ReadWebTable() {
	
	System.out.println("Inside webtable");
	List<WebElement> AllFirstName = driver.findElements(WebTable.FirstName);
	int size = AllFirstName.size();
	System.out.println("Number of first names:"+size);
	for(int i=2;i<=size;i++){
		String FirstName = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2] ")).getText();
     if(FirstName.equalsIgnoreCase(objProperties.getProperty("webTableFirstName"))) {

    	 String LastName = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
    	 System.out.println("Last name is :"+LastName);
    	 break;
    	 
    	 
    	 
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
