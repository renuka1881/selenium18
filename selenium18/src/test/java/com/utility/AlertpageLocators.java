package com.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlertpageLocators  {
	
	public static By NormalAlert = By.id("alertButton");
	public static By TimerAlert = By.id("timerAlertButton");
	public static By ConfirmAlert = By.id("confirmButton");
	public static By PromptAlert = By.id("promtButton");
	public static By ConfirmCancelMessage = By.id("confirmResult");
	public static By PromptMessage = By.id("promptResult");
 public static void ClickOnAlert(By AlertType1 ) {
	 
	 Libraryfile.driver.findElement(AlertType1).click();
	
	 
 }
 public static void ExplicitWaitfoAlertIsPresent() {
		WebDriverWait wait =new WebDriverWait(Libraryfile.driver,Constants.ExplicitWait);
		wait.until(ExpectedConditions.alertIsPresent());
	}

		
		 
}
