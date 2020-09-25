package com.syntax.review;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionsClassRecap extends CommonMethods{
	/*
	 * What is Actions class and why do we need it? 
	 * 1. We need simulate mouse and keyboard actions 
	 * 2. Some elements may not be available before we hover the mouse on it
	 */

	public static final String ORANGE_HRM_URL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", ORANGE_HRM_URL);

		// 1. login OrangeHRM

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		Thread.sleep(3000);

		// Scenario - Navigate to WorkWeek page by using actions class

		// 1. Create an object of Actions class
		Actions action=new Actions(driver);

		// 2. Create a locator for the page object
		WebElement leaveBtn=driver.findElement(By.id("menu_leave_viewLeaveModule"));

		// 3. Perform operation by using the created object

		action.moveToElement(leaveBtn).perform();

		Thread.sleep(2000);

		WebElement configBtn=driver.findElement(By.linkText("Configure"));
		action.moveToElement(configBtn).perform();

		Thread.sleep(2000);

		WebElement workWeekBtn=driver.findElement(By.linkText("Work Week"));

		action.click(workWeekBtn).perform();

		Thread.sleep(3000);
		driver.quit();


		/* most common methods for Actions class for mouse
		 * 1. click()
		 * 2. doubleClick()
		 * 3. contextClick()
		 * 4. moveToElement()
		 * 5. dragAndDrop(WebElement src, WebElement dest)
		 * 
		 * What are the most common keyboard operations
		 * 	1. TAB
		 * 	2. CTRL
		 * 	3. SHIFT
		 *  4. keyDown()
		 *  5. keyUp()
		 */

	}
}


