package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorBasic {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.get("https://www.toolsqa.com/selenium-training/#enroll-form");
//		1. xpath------2
		Driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("Santosh");
		Driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("Gadekar");
		Driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("xyz123@gmail.com");
//		2.id------1
//		Driver.findElement(By.id("first-name")).sendKeys("Santosh");
//		3.name------3
//		Driver.findElement(By.name("firstName")).sendKeys("Santosh");
//		4.link text------this method is only for links
//		Driver.get("https://www.toolsqa.com/selenium-training/");
//		Driver.findElement(By.linkText("GO TO REGISTRATION")).click();
//      5.partial link text------this method is not useful
//		Driver.get("https://www.toolsqa.com/selenium-training/");
//		Driver.findElement(By.partialLinkText("Go To")).click();
//		6.CSSSelector------2
//		If id is there ------#{id}
//		If id is not there------.{class}
//		Driver.findElement(By.cssSelector("#mobile")).sendKeys("9923795869"); //Here using value of id attribute after # keyword
//		7. class name: It can be same for different tag, so it is not used.------4
//		Driver.findElement(By.className("")).sendKeys("");
		Driver.quit();
	}
}

