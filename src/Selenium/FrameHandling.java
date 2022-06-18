package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FrameHandling {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://demo.guru99.com/test/guru99home");
		Driver.switchTo().frame("a077aa5e"); // switching the frame by ID
		Thread.sleep(3000);
		System.out.println("********We are switch to the iframe*******");
		Driver.findElement(By.xpath("html/body/a/img")).click();
		Thread.sleep(3000);
		// Clicks the iframe
		System.out.println("*********We are done***************");
		Thread.sleep(2000);
		Driver.quit();
	}
}
