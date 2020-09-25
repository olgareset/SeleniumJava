package com.syntax.review;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynconizationInSelenium extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {


		setUp("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		driver.manage().window().maximize();

		// define pageLoadTimeout

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// whit which methods pageLoadTimeout() works? --> get(), navigate().to()



		// define implicitWait for selenium
		// defined once and works as long as the driver object session continues
		// it works with findElement() and findElements() methods.

		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);

		// login on OrangeHrm
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		driver.findElement(By.id("btnLogin")).click();

		// navigate to add Employee Page

		// ExplicitWaits --> webDriverWait

		// 1. Create an object of WabDriverWait class
		WebDriverWait wait=new WebDriverWait(driver, 20);

		// 2. scpecify a condition for the wait object

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));

		// 3. do your action
		driver.findElement(By.linkText("PIM")).click();

		// specify an expected condition

		WebElement addEmpBtn=driver.findElement(By.linkText("Add Employee"));		
		wait.until(ExpectedConditions.elementToBeClickable(addEmpBtn));
		addEmpBtn.click();

		// What happens if the expected condition occurs immediately?		

		Thread.sleep(3000);

		driver.quit();
	}
}
