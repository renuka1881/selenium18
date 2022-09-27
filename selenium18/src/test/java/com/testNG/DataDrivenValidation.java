package com.testNG;

import org.testng.annotations.Test;

import com.pages.DataDrivenPage;
import com.pages.WebTable;
import com.utility.Constants;
import com.utility.Libraryfile;
import com.utility.Libraryfile2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class DataDrivenValidation extends Libraryfile2 {

	@Test(priority = 0)

	public void DataDrivenPages() {

		System.out.println("Inside Data Driven Page");
		driver.get(objProperties.getProperty("DataDrivenURL"));
		WaitingForPageToLoad(Constants.pageloadtimeout);
		waitForPageToLoad();
		String TitleofDataDivenPage = driver.getTitle();
		System.out.println("Title is :" + TitleofDataDivenPage);
		Assert.assertEquals(TitleofDataDivenPage, objProperties.getProperty("DataDrivenTitle"));
	}

	@SuppressWarnings("resource")
	@Test(priority = 1)

	public void DataDrivenValidation() throws InterruptedException {

		System.out.println("Inside Validate Data Driven");
		try {
			File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//StudentRegister.xlsx");
			FileInputStream objInputStream = new FileInputStream(objFile);

			XSSFWorkbook objXSSWorkbook = new XSSFWorkbook(objInputStream);
			XSSFSheet objXSSFSheet = objXSSWorkbook.getSheet(objProperties.getProperty("DataDrvienSheetName"));

			int NumofRows = objXSSFSheet.getLastRowNum();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)");

			for (int row = 1; row <= NumofRows; row++) {
				Hmap = ReadEXFile(objXSSFSheet, row);
				System.out.println("Hmap is :" + Hmap);

				driver.findElement(DataDrivenPage.FirstName).clear();
				driver.findElement(DataDrivenPage.FirstName).sendKeys(Hmap.get("FirstName"));

				driver.findElement(DataDrivenPage.LastName).clear();
				driver.findElement(DataDrivenPage.LastName).sendKeys(Hmap.get("LastName"));

				driver.findElement(DataDrivenPage.Email).clear();
				driver.findElement(DataDrivenPage.Email).sendKeys(Hmap.get("EmailAddress"));

				if (Hmap.get("Gender").equalsIgnoreCase("Male")) {
					driver.findElement(DataDrivenPage.GenderMale).click();
				} else if (Hmap.get("Gender").equalsIgnoreCase("Female")) {
					driver.findElement(DataDrivenPage.GenderFemale).click();

				} else
					driver.findElement(DataDrivenPage.GenderOther).click();
				//driver.findElement(DataDrivenPage.DateOfBirth).click();
								
				driver.findElement(DataDrivenPage.MobileNumber).clear();
				driver.findElement(DataDrivenPage.MobileNumber).sendKeys(Hmap.get("PhoneNumber"));
				WebElement element=driver.findElement(DataDrivenPage.DateOfBirth);
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
				WebElement element1 = driver.findElement(DataDrivenPage.MonthDropDown);

				JavascriptExecutor js2 = (JavascriptExecutor) driver;
				js2.executeScript("arguments[0].scrollIntoView(true);", element1);
				
				element1.click();
				List<WebElement> AllMonths = driver.findElements(DataDrivenPage.AllMonths);
				SelectValueFromDropDown(AllMonths,Hmap.get("Month"));
				
				driver.findElement(DataDrivenPage.DropDrownYear).click();
				List<WebElement> AllYears = driver.findElements(DataDrivenPage.AllYear);
				SelectValueFromDropDown(AllYears,Hmap.get("Year"));
								
				List<WebElement> AllDays = driver.findElements(DataDrivenPage.AllDays);
				int count = AllDays.size();
				for(int i=0; i<=count-1;i++) {
					String CalenderDay = AllDays.get(i).getText();
					if(CalenderDay.equals(Hmap.get("Date"))){
						AllDays.get(i).click();
						break;
					}
				}
							
			// driver.findElement(DataDrivenPage.Subjects).clear();
			// driver.findElement(DataDrivenPage.Subjects).sendKeys(Hmap.get("Subjects"));
			 
			  if (Hmap.get("Hobbies").equalsIgnoreCase("Sports")) {
			  driver.findElement(DataDrivenPage.HobbiesSports).click();
			  } 
			  
			  else if(Hmap.get("Hobbies").equalsIgnoreCase("Reading")) {
			  driver.findElement(DataDrivenPage.HobbiesReading).click(); 
			  } 
			  else {
			 driver.findElement(DataDrivenPage.HobbiesMusic).click();
			 }
			//writing to excel file
				FileOutputStream objFileOutput =  new FileOutputStream(objFile);
				WritetoExcelFile(objXSSWorkbook,objXSSFSheet,row);
				objXSSWorkbook.write(objFileOutput);
				
					 
			}
			objXSSWorkbook.close();
			objInputStream.close();
			
		}

		catch (Exception e) {
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
	public void beforeTest() throws InterruptedException {
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
