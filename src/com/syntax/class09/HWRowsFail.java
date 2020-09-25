package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// HW find rows with fail

public class HWRowsFail {
	
	public static String url = "http://syntaxtechs.com/selenium-practice/table-pagination-demo.php";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'table table-hover']/tbody/tr"));
		WebElement next = driver.findElement(By.xpath("//a[@class='next_link']"));
		
		int rowsSize = rows.size();
		int count = 0;
		
		while (count<rowsSize) {
			for(WebElement row:rows) {
				count++;
				String rowText = row.getText();
				if(rowText.contains("Fail")) {
					System.out.println(rowText);
					break;
				}
			
			}if(count<rowsSize) {
					next.click();
				}
			}
			driver.quit();
		}
}

