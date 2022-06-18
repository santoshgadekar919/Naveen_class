package Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpWindow2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://www.seleniumframework.com/Practiceform/");
		Driver.findElement(By.id("button1")).click();
		Set<String> handler=Driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
		String Parent=it.next();
		System.out.println(Parent);
		String Child=it.next();
		System.out.println(Child);
		Driver.switchTo().window(Child);
		System.out.println("Child Title"+ Driver.getTitle());
		Driver.close();
		Driver.switchTo().window(Parent);
		System.out.println("Parent Title"+ Driver.getTitle());
		Driver.quit();
	}

}
