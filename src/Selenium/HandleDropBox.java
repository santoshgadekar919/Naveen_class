package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.get("https://www.toolsqa.com/selenium-training/#enroll-form");
//		Select from DropDown
		Select select=new Select(Driver.findElement(By.id("country")));
//		select.selectByVisibleText("India");
		select.selectByIndex(0);
		Thread.sleep(3000);
		Driver.quit();

	}

}
