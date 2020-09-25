package com.syntax.review;
import org.openqa.selenium.By;
public class UploadFiles extends CommonMethods {
	
	public static final String ORANGE_HRM_URL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";

public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", ORANGE_HRM_URL);
		
		// How to upload files with selenium?  sendKeys() method
		
		// 1. Login on OrangeHRM
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(500);
		
		
		// 2. Navigate to Add Employee page
		
		driver.findElement(By.linkText("PIM")).click();
		
		Thread.sleep(500);
		
		driver.findElement(By.linkText("Add Employee")).click();
		
		// 3. Add an employee and save it
		Thread.sleep(500);
		
		driver.findElement(By.id("firstName")).sendKeys("Donald");
		Thread.sleep(500);
		driver.findElement(By.id("lastName")).sendKeys("Duck");
		Thread.sleep(500);
		
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(500);
		
		// 4. Upload a picture for the employee
		
		driver.findElement(By.id("empPic")).click();
		Thread.sleep(500);
		
		driver.findElement(By.id("photofile")).sendKeys("C:/Users/hvanl/Pictures/55.jpg");
		driver.findElement(By.id("btnSave")).click();
		
		
		Thread.sleep(5000);
		driver.quit();
			
	}

}
