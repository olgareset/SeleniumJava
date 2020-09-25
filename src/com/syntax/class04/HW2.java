package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2 {
	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) {
// HRMS Application Negative Login:
//	Open chrome browser
//	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//	Enter valid username
//Leave password field empty. Verify error message with text “Password cannot be empty” is displayed.


		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input.button")).click();
		
		WebElement text = driver.findElement(By.id("spanMessage"));
		boolean isDisplayed = text.isDisplayed();
		System.out.println("Error message is displayed: "+isDisplayed);
		
	}

}
