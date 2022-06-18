package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
//		boolean b1=Driver.findElement(By.id("demo")).isEnabled();
//		System.out.println(b1);
		Driver.get("https://www.browserstack.com/users/sign_up?ref=guide-isdisplayed-method-in-selenium&product=automate");
//		1. isDisplayed(): This method is applicable for all the elements
		boolean b1=Driver.findElement(By.id("user_submit")).isDisplayed();
		System.out.println(b1); //true
		
//		2. isEnabled():
		boolean b2=Driver.findElement(By.id("user_submit")).isEnabled();
		System.out.println(b2); //true
		
//		Select  I agree to BrowserStack's Terms of Service and Privacy Policy checkbox
//		3. isSelected(): 
		WebElement click=Driver.findElement(By.id("tnc_checkbox")); 
		clickElementByJS(Driver,click); //Select the checkbox
		boolean b3=click.isSelected();
		System.out.println(b3); //true
		
		clickElementByJS(Driver,click);//deSelect the checkbox
		boolean b4=click.isSelected();
		System.out.println(b4); //false
		
		Driver.quit();
		
	}
	public static void clickElementByJS(WebDriver Driver, WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("arguments[0].click();", element);
	}

}
