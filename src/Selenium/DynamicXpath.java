package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DynamicXpath {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://automationpractice.com/index.php");

//		Absolute xpath: Do not used this /html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a
//		Disadvantages-1.Performance issue,2. not reliable, 3. can be changed at any time in future
//		Driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
		
		Driver.findElement(By.xpath("//*[@class=\"login\"]")).click();
		
//		Following are the ways the same web element can be accessed
//		Driver.findElement(By.xpath("//input[@class=\"is_required validate account_input form-control\"]")).sendKeys("santosh");
//		Driver.findElement(By.xpath("//*[@name=\"email_create\"]")).sendKeys("santosh");
//		Driver.findElement(By.id("email_create")).sendKeys("santosh");
		
//		Driver.findElement(By.xpath("//input[contains(@class,\"is_required validate account_input form-control\")]")).sendKeys("santosh");
		
//		Dynamic id:
//		Every time the value of the id attribute gets change
//		id=test_123
//		By.id("test_123")
//		id=test_456
//		id=test_789
//		Here we can use contains method
		
//		Driver.findElement(By.xpath("//input[contains(@id,\"email_\")]")).sendKeys("santosh");
		
		Driver.findElement(By.xpath("//input[starts-with(@id,\"email_\")]")).sendKeys("santosh222");
		
//		for links: 
//		all links are represented by <a> html tag
//		Driver.findElement(By.xpath("//*[contains(text(),\"Cart\")]")).click();
		
		Driver.findElement(By.id("SubmitCreate")).click();
		WebElement m=Driver.findElement(By.id("create_account_error"));
		String p=m.getText();
		System.out.println(p);
		Thread.sleep(5000);
		Driver.quit();

	}

}
