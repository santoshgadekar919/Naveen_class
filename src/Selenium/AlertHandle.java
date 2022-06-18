package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.get("https://mypage.rediff.com/login/dologin");
		Driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		Alert alert=Driver.switchTo().alert();
		System.out.println(alert.getText());
//		it is used to click on ok button
//		alert.dismiss(); 
//		it is used to click on cancel button
		String at=alert.getText();
		
//		Alert Text Validation
		if(at.equals("Please enter valid email")) {
			System.out.println("Correct Alert");
			alert.accept();
			Driver.quit();
		}
		else {
			System.out.println("Incorrect Alert");
			}
		
	}

}
