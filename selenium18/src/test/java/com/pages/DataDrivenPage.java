package com.pages;

import org.openqa.selenium.By;

public class DataDrivenPage {
	
	public static By FirstName = By.xpath("//input[@placeholder='First Name']");
	public static By LastName = By.xpath("//input[@placeholder='Last Name']");
	public static By Email = By.xpath("//input[@id='userEmail']");
	public static By GenderMale = By.xpath("//*[contains(text(),'Male')]");
	public static By GenderFemale = By.xpath("//*[contains(text(),'Female')]");
	public static By GenderOther = By.xpath("//*[contains(text(),'Other')]");
	public static By MobileNumber = By.xpath("//*[@placeholder='Mobile Number']");
	public static By DateOfBirth = By.id("dateOfBirthInput");
	public static By MonthDropDown = By.xpath("//*[@class='react-datepicker__month-select']");
	public static By AllMonths = By.xpath("//*[@class='react-datepicker__month-select']/option");
	public static By DropDrownYear = By.xpath("//*[@class='react-datepicker__year-select']");
	public static By AllYear = By.xpath("//*[@class='react-datepicker__year-select']/option");
	public static By AllDays = By.xpath("//div[@role='listbox']/div/div");
	public static By Subjects = By.xpath("//*[@id='subjectsContainer']/div/div[1]");
	public static By HobbiesSports = By.xpath("//label[contains(text(),'Sports')]");
	public static By HobbiesReading = By.xpath("//*[contains(text(),'Reading')]");
	public static By HobbiesMusic = By.xpath("//*[contains(text(),'Music')]");
	

	

}
