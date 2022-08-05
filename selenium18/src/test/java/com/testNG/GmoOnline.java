package com.testNG;

import org.testng.annotations.Test;

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

public class GmoOnline extends Libraryfile {
	
 //WebDriver driver;
	
  @Test (priority=0)
  public void ValidateGmoOnline () {
	  System.out.println("Validate Gmoonline");
	  String titleofgmoOnline = driver.getTitle();
		 System.out.println("titleOfGmoOnline:"+titleofgmoOnline);
Assert.assertEquals(titleofgmoOnline, objProperties.getProperty("GmoOnlineTitle"));
  
  }
 @SuppressWarnings("deprecation")
@Test(priority=1,dependsOnMethods = {"ValidateGmoOnline"})
 public void validateEnterGmoOnline() {
	driver.findElement(By.name("bSubmit")).click(); 
	driver.manage().timeouts().pageLoadTimeout(Constants.pageloadtimeout,TimeUnit.SECONDS);
	driver.findElement(By.name("QTY_GLASSES")).clear();
	driver.findElement(By.name("QTY_GLASSES")).sendKeys(Constants.quantityofglasses);
	driver.findElement(By.name("bSubmit")).click();
	@SuppressWarnings("unused")
	String tittleofplaceorder =driver.getTitle();
	Assert.assertEquals(tittleofplaceorder, objProperties.getProperty("Titleofplaceorder"));
	String UnitPrice = driver.findElement(By.xpath("//table[@cellpadding='4' and @border ='1']/tbody/tr[2]/td[4]")).getText().substring(2);
	System.out.println(" unit price is"+UnitPrice);
	Float UnitPriceInFloatTotal=Float.parseFloat(UnitPrice)* Float.parseFloat(Constants.quantityofglasses);
	System.out.println("Calculated value is:"+UnitPriceInFloatTotal);
	
	String UnitPriceInTotalfromApp = driver.findElement(By.xpath("//table[@cellpadding='4' and @border ='1']/tbody/tr[2]/td[5]")).getText().substring(2);
	Float UnitPriceinTotalfromAppFloat= Float.parseFloat(UnitPriceInTotalfromApp);
	System.out.println(" totalprice from App:"+UnitPriceinTotalfromAppFloat);
	Assert.assertEquals(UnitPriceInFloatTotal,UnitPriceinTotalfromAppFloat );
	
	String salestax =driver.findElement(By.xpath("//table[@cellpadding='4' and @border ='1']/tbody/tr[4]/td[2]")).getText().substring(2);
	Float SalestaxFloat= Float.parseFloat(salestax);
	String Sh = driver.findElement(By.xpath("//table[@cellpadding='4' and @border ='1']/tbody/tr[5]/td[2]")).getText().substring(2);
	Float FloatSh = Float.parseFloat(Sh);
	Float GrandTotal = UnitPriceInFloatTotal+SalestaxFloat+FloatSh;
	System.out.println(" grand total:"+GrandTotal);
	
	String GrandTotalfromApp = driver.findElement(By.xpath("//table[@cellpadding='4' and @border ='1']/tbody/tr[6]/td[2]")).getText().substring(2);
	Float GrandTotalfromAppFloat = Float.parseFloat(GrandTotalfromApp);
	System.out.println(" garnd total from app:"+GrandTotalfromAppFloat);
	Assert.assertEquals(GrandTotal,GrandTotalfromAppFloat );
			
	
	
	
	
	
	
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
