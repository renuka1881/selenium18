package com.utility;

import org.openqa.selenium.By;

public class Frames1 {
	public static String  OutsideFrame="iamframe";
	public static By InnerFrame = By.xpath("//*[@id='frame3']");
   public static By InsideInnerFrame= By.xpath("//*[@id=\"a\"]");
   public static By InsideOuterFrame=By.xpath("/html/body/input");
}
