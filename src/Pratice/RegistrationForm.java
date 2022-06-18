package Pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
//		Dynamic Wait
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Driver.findElement(By.id("email_create")).sendKeys("abc6988dhdghl@gmail.com");
		Driver.findElement(By.id("SubmitCreate")).click();
		Driver.findElement(By.id("id_gender1")).click();
		Driver.findElement(By.id("customer_firstname")).sendKeys("Santosh");
		Driver.findElement(By.id("customer_lastname")).sendKeys("Gadekar");
		Driver.findElement(By.id("passwd")).sendKeys("Santosh123");
		Select date=new Select(Driver.findElement(By.id("days")));
		date.selectByValue("24");
		Select month=new Select(Driver.findElement(By.id("months")));
		month.selectByValue("1");
		Select year=new Select(Driver.findElement(By.id("years")));
		year.selectByValue("1992");
		Driver.findElement(By.id("newsletter")).click();
		Driver.findElement(By.id("optin")).click();
		Driver.findElement(By.id("company")).sendKeys("JSPMBSIOTR");
		Driver.findElement(By.id("address1")).sendKeys("Wagholi");
		Driver.findElement(By.id("city")).sendKeys("Pune");
		Select state=new Select(Driver.findElement(By.id("id_state")));
		state.selectByValue("1");
		Driver.findElement(By.id("postcode")).sendKeys("51838");
		Driver.findElement(By.id("other")).sendKeys("Nothing Else");
		Driver.findElement(By.id("phone_mobile")).sendKeys("9923795869");
		Driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(5000);
		if(Driver.getTitle().contains("My Account")) {
		System.out.println("User Successfully Created");
		}
		else {
		System.out.println("Please check for error....User not Created");	
		}
		Driver.quit();
	}

}
