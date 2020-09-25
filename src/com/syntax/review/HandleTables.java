package com.syntax.review;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HandleTables extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {


		setUp("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		// we have two kind of tables in our web applications
		// What are they?  --> Static and Dynamic
		// If the number of columns are rows are fixed --> Static
		// If the number of columns are rows are changeable--> Dynamic

		// What kind of parts a table has?
		// Header and Body
		// columns rows

		// 1. login OrangeHRM

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		// 2. Navigate to Employee List Page

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Employee List")).click();


		// 3. Verify Headers



		String [] headers= {"Id", "First (& Middle) Name", "Last Name", "Job Title", "Employment Status",
				"Sub Unit", "Supervisor"};

		List<WebElement> headerList=driver.findElements(By.xpath("//table[@id='resultTable']/thead/tr/th"));

		int i=1;
		for(String header:headers) {
			if(header.equals(headerList.get(i).getText())) {
				System.out.println(headerList.get(i).getText());
				System.out.println(header+ " test pass");

			}else {
				System.out.println(headerList.get(i).getText());
				System.out.println(header+" test fail");
			}
			i+=1;
		}

		Thread.sleep(3000);

		driver.quit();

	}
}
