package Selenium;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HtmlUnitDriver1 {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		 // Creating a new instance of the HTML unit driver
        WebDriver Driver = new HtmlUnitDriver();
		Driver.manage().deleteAllCookies();
//		Dynamic Wait
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://www.google.com");

		System.out.println("Title---------" +Driver.getTitle());
       
       Driver.quit();	
	}
}
