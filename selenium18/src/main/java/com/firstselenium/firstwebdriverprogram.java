package com.firstselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstwebdriverprogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     WebDriver driver;
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver(); 
     driver.get("https://www.google.com/"); 
     driver.manage().window().maximize();
	}

}
