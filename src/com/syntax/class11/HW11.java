package com.syntax.class11;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW11 {
	
	public static String url = "http://www.uitestpractice.com/Students/Index";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Table
		List<WebElement>rows = driver.findElements(By.xpath("//tbody/tr"));
		for(int i=0; i<rows.size(); i++) {
			String rowText = rows.get(i).getText();
			if(rowText.contains("Donald")) {
				WebElement column = driver.findElements(By.xpath("//tbody/tr/td[4]")).get(i-1);
				String textCol = column.getText();
				if(textCol.equals("DELETE")) {
					column.click();
				}
				break;
			}
		}
		
		// AjaxCall
		WebElement ajaxLinkButton = driver.findElement(By.xpath("//a[text() = 'AjaxCall']"));
		ajaxLinkButton.click();
		WebElement ajaxLink = driver.findElement(By.xpath("//a[text() = 'This is a Ajax link']"));
		ajaxLink.click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ContactUs']")));
		String ajaxLinkText = driver.findElement(By.xpath("//div[@class = 'ContactUs']")).getText();
		System.out.println(ajaxLinkText);
		
		// Form
		WebElement formLinkButton = driver.findElement(By.xpath("//a[text() = 'Form']"));
		formLinkButton.click();
		
		WebElement firstName = driver.findElement(By.id("firstname"));
		firstName.sendKeys("Grace");
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.sendKeys("Kelly");
		
		// radio button
		List<WebElement>MaritalStat = driver.findElements(By.xpath("//label[@class='radio-inline']"));
		for(WebElement status : MaritalStat) {
			if(status.getText().equalsIgnoreCase("Married")) {
				status.click();
				Thread.sleep(2000);
				break;
			}
		}
		List<WebElement>hobby = driver.findElements(By.xpath("//label[@class = 'checkbox-inline']"));
		for(WebElement hobbies:hobby) {
			if(hobbies.getText().equalsIgnoreCase("reading")) {
				hobbies.click();
				Thread.sleep(2000);
				break;
			}
		}
		// Drop Down
		WebElement country = driver.findElement(By.xpath("//select[@class='form-control dropdown-header']"));
		Select select = new Select(country);
		select.selectByVisibleText("Iceland");
		
		// Calendar
		WebElement calendar = driver.findElement(By.id("datepicker"));
		calendar.click();
		
		WebElement monthDOB = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select monthSelected = new Select(monthDOB);
		monthSelected.selectByVisibleText("May");
		
		WebElement yearDOB = driver.findElement(By.className("ui-datepicker-year"));
		Select yearSelected = new Select(yearDOB);
		yearSelected.selectByVisibleText("1970");
		
		List<WebElement>dayDOB = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for(WebElement day : dayDOB) {
			if(day.getText().equals("18")) {
				day.click();
				break;
			}
		}
		// Rest of the info on the form:
		WebElement phNumber = driver.findElement(By.id("phonenumber"));
		phNumber.sendKeys("1234569575");
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Jjones");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("jones123@yahoo.com");
		WebElement aboutYourself = driver.findElement(By.id("comment"));
		aboutYourself.sendKeys("This is homework");
		WebElement password = driver.findElement(By.id("pwd"));
		password.sendKeys("jones321");
		WebElement submitBtn = driver.findElement(By.xpath("//button[text() = 'Submit']"));
		String submitButtonText = submitBtn.getText();
		System.out.println("Submit button text is: "+submitButtonText);
		submitBtn.click();
		
		// Controls
		WebElement controlLink = driver.findElement(By.xpath("//a[text() = 'Controls']"));
		controlLink.click();
		
		// Drag and Drop
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(draggable, droppable).perform();
		WebElement dropped = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
		System.out.println("Dropped text is: "+dropped.getText());
		
		// Button Double Click
		WebElement doubleClickBtn = driver.findElement(By.name("dblClick"));
		action.doubleClick(doubleClickBtn).perform();
		
		// Alert
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println("Text in Alert window is: "+alertMessage);
		alert.accept();
		
		// iFrame
		driver.switchTo().frame("iframe_a");
		WebElement EnterNameBox = driver.findElement(By.id("name"));
		EnterNameBox.sendKeys("John Doe");
		driver.switchTo().defaultContent();
		
		// click on the button to open new window
		WebElement watchVidBtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[6]/button/a"));
		watchVidBtn.click();
		String mainPaige = driver.getWindowHandle();
		
		Set<String>allWindows = driver.getWindowHandles();
		for(String currentWindow : allWindows) {
			if(!currentWindow.equals(mainPaige)) {
				driver.switchTo().window(currentWindow);
				System.out.println("Child page: "+ driver.getCurrentUrl());
				driver.close();
			}
		}
		driver.switchTo().window(mainPaige);
		System.out.println("Main page: "+ driver.getCurrentUrl());
		
		// Widgets
//		WebElement widgetsLink = driver.findElement(By.xpath("//a[text()='Widgets']"));
//		widgetsLink.click();
		
		// Upload Image
//		WebElement chooseFile = driver.findElement(By.id("image_file"));
//		chooseFile.sendKeys("C:\\Users\\woodl\\OneDrive\\Documents\\Selenium\\SampleTestData.xlsx");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Upload']")));
//		WebElement upload = driver.findElement(By.xpath("//input[@value='Upload']"));
//		upload.click();
//		WebElement uploadedText = driver.findElement(By.xpath("//*[@id=\"upload_response\"]/div/p"));
//		System.out.println("Text from uploaded box: "+ uploadedText.getText());
		
		// Actions
//		WebElement actions = driver.findElement(By.xpath("//a[text()='Actions']"));
//		actions.click();
		
		//click
		
//		WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me !']"));
//		clickMe.click();
//		wait.until(ExpectedConditions.alertIsPresent());
//		driver.switchTo().alert();
//		System.out.println("Message from Alert window: "+alert.getText());
//		alert.accept();
		
		//double click
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Double Click Me !']")));
//		WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double Click Me !']"));
//		action.doubleClick(doubleClick).perform();
//		driver.switchTo().alert();
//		System.out.println("Message from Double click box: "+ alert.getText());
//		alert.accept();
		
		// drag and drop
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
//		WebElement drag = driver.findElement(By.id("draggable"));
//		WebElement drop = driver.findElement(By.id("droppable"));
//		action.dragAndDrop(drag, drop).perform();
		
		// Numbers
		
//		Thread.sleep(2000);
//		List<WebElement>numbers = driver.findElements(By.xpath("//ol[@class='ui-selectable'/li]"));
//		System.out.println("Numbers: "+ numbers.size());
		
//		for(int i=0; i<numbers.size(); i++) {
//			action.clickAndHold(numbers.get(0)).perform();
//			String num = numbers.get(i).getText();
//			if(num.equalsIgnoreCase("12")) {
//				action.clickAndHold(numbers.get(i)).release().perform();
//				break;
//			}
//		}
		// Switch to
		WebElement swithTo = driver.findElement(By.xpath("//a[text()='Switch to']"));
		swithTo.click();
		
		//simple alert
		WebElement alertBtn = driver.findElement(By.id("alert"));
		alertBtn.click();
		driver.switchTo().alert();
		System.out.println("Message alert: "+alert.getText());
		alert.accept();
		
		// Confirm alert
		WebElement confirmBtn = driver.findElement(By.id("confirm"));
		confirmBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		System.out.println("Confirm message: "+alert.getText());
		alert.dismiss();
		
		// Prompt alert
		WebElement promptBtn = driver.findElement(By.id("prompt"));
		promptBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		alert.sendKeys("Name Name");
		Thread.holdsLock(1500);
		alert.accept();
		
		// Launch modal
		WebElement modal = driver.findElement(By.xpath("//button[@data-target='#myModal']"));
		modal.click();
		String modalText = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
		System.out.println("Modal message: "+modalText);
		WebElement closeModal = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		closeModal.click();
		
		//Frame
		driver.switchTo().frame("iframe_a");
		WebElement enterName = driver.findElement(By.id("name"));
		enterName.sendKeys("Name entered");		
		driver.switchTo().defaultContent();
		
		// Opens in a new window
	//	WebElement opensNewWindow = driver.findElement(By.xpath("//a[text()='Opens in a new window']"));
	//	opensNewWindow.click();
		
		//Select
		WebElement SwitchLink = driver.findElement(By.xpath("//a[text()='Select']"));
		SwitchLink.click();
		// Drop Down
		WebElement dd = driver.findElement(By.id("countriesSingle"));
		dd.click();
		Select selectDD = new Select(dd);
		selectDD.selectByVisibleText("England");
		
		// Multiple select
		WebElement multiSelect = driver.findElement(By.id("countriesMultiple"));
		Select mSelect = new Select(multiSelect);
		boolean isMultiple = mSelect.isMultiple();
		System.out.println("Multiple select: "+ isMultiple);
		List<WebElement>options = mSelect.getOptions();
		for(WebElement option:options) {
			String text1=option.getText();
			mSelect.selectByVisibleText(text1);
			Thread.sleep(2000);
			
		WebElement multiDD = driver.findElement(By.id("dropdownMenu1"));
		multiDD.click();
		List<WebElement>countries = driver.findElements(By.xpath("//ul[@class='dropdown-menu']"));
		for(WebElement Country:countries) {
			if(Country.getText().equalsIgnoreCase("China")) {
				Country.click();
				break;
			}
		}
		// Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		try{
			FileUtils.copyFile(sourceFile, new File("screenshots/HW11.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.quit();			
			
		}
}
}
