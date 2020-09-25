package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	//launch the Chrome Amazon
	//navigate to amazon.com
	//print out the titie and the url
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://amazon.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
	}

}
