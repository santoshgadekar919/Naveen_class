package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.get("https://www.browserstack.com/");
		Actions action=new Actions(Driver);
		action.moveToElement(Driver.findElement(By.xpath("//button[@id=\"developers-menu-toggle\"]"))).build().perform();
		Driver.findElement(By.linkText("Documentation")).click();
	}

}
