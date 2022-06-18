package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/droppable");
		Actions action=new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//div[@id=\"draggable\"]"))).moveToElement(driver.findElement(By.xpath("//div[@id=\"droppable\"]"))).release().build().perform();
		Thread.sleep(5000);
		driver.quit();

	}

}
