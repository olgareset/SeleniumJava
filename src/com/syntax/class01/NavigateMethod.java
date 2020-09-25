package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {

	public static void main(String[] args) throws InterruptedException { 

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://google.com");
		Thread.sleep(2000); // it will pause for two seconds
		//driver.navigate().to("http://facebook.com"); // we put // to make next task
		// execute sooner
		// driver.navigate().back();
		// driver.navigate().forward();
		 driver.navigate().refresh();
		 Thread.sleep(3000);
		// driver.manage().window().fullscreen(); // or use word "maximize" instead of "fullscreen"		 
		 
		 driver.close(); // closes the tab
		 //driver.quit();//closes the whole browser
		 
		 
		 
	}

}
