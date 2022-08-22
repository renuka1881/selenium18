
package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Libraryfile {
	public static Properties objProperties;
	public static WebDriver driver;
	public static HashMap<String,String> Hmap = new HashMap<String,String>();

public  void ReadPropertyfile()  {
	System.out.println("location of project:" + System.getProperty("user.dir"));
	File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//config.properties");
	FileInputStream ObjInputStream;
	try {
		ObjInputStream = new FileInputStream(objFile);
		objProperties = new Properties();	
		objProperties.load(ObjInputStream);
		System.out.println(objProperties.getProperty("Browser"));
		System.out.println(objProperties.getProperty("Flipkart"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void launchbrowser() {
	String browserinfo = objProperties.getProperty("Browser");
	switch(browserinfo) {
	case "Chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		/*ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		//chromePrefs.put("profile.default_content_settings.popups", 0);
		//chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(options);*/
		break;
	case "IE":
		WebDriverManager.iedriver().setup();
		driver =new InternetExplorerDriver();
		break;
	}
	//driver.get(objProperties.getProperty("GmoOnlineURL"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}
		
	public static void ExplicitWaitfoAlertIsPresent() {
		WebDriverWait wait =new WebDriverWait(driver,Constants.ExplicitWait);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	

public static HashMap<String, String> ReadEXFile(XSSFSheet objXSSFSheet, int row) {
	// TODO Auto-generated method stub
	DataFormatter objDataFormatter =  new DataFormatter();
	
	Hmap.put("RunMode", objXSSFSheet.getRow(row).getCell(0).getStringCellValue());
	Hmap.put("TesCaseName", objXSSFSheet.getRow(row).getCell(1).getStringCellValue());
	Hmap.put("FirstName", objXSSFSheet.getRow(row).getCell(2).getStringCellValue());
	Hmap.put("LastName", objXSSFSheet.getRow(row).getCell(3).getStringCellValue());
	Hmap.put("Gender", objXSSFSheet.getRow(row).getCell(4).getStringCellValue());
	Hmap.put("EmailAddress", objXSSFSheet.getRow(row).getCell(5).getStringCellValue());
	Hmap.put("PhoneNumber",objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(6)));
	Hmap.put("DateofBirth", objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(7)));;
	Hmap.put("Subjects", objXSSFSheet.getRow(row).getCell(8).getStringCellValue());
	Hmap.put("Hobbies", objXSSFSheet.getRow(row).getCell(9).getStringCellValue());
	//Hmap.put("Image", objXSSFSheet.getRow(row).getCell(10).getStringCellValue());
	Hmap.put("Address", objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(10)));
	


	return Hmap;


	

}
}
	
	



