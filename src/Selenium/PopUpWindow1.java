package Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpWindow1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://demo.guru99.com/popup.php");
		Driver.findElement(By.linkText("Click Here")).click();
		Set<String> handler=Driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String parentWindowid=it.next();
		System.out.println("parent window id" +parentWindowid);
		String childWindowid=it.next();
		System.out.println("child window id" +childWindowid);
		Driver.switchTo().window(childWindowid);
		System.out.println("Child Window Title "+ Driver.getTitle());
		Driver.close();
		Driver.switchTo().window(parentWindowid);
		System.out.println("Parent Window Title "+ Driver.getTitle());
		Driver.quit();
	}
}
