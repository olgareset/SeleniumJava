package com.syntax.review;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class CalendarRecap extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();


		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();

		driver.findElement(By.id("calFromDate")).click();

		WebElement months=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[1]"));

		WebElement years=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/select[2]"));

		Select mSelect=new Select(months);
		Select ySelect=new Select(years);

		mSelect.selectByVisibleText("Jul");
		ySelect.selectByVisibleText("2019");

		Thread.sleep(3000);

		driver.quit();
	}
}

