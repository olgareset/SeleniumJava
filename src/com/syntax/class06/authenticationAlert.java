package com.syntax.class06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class authenticationAlert {
	
	public static String url = "http://test:test@abcdatabase.com/basicauth";
	                                 //username:password@  
	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

}
}