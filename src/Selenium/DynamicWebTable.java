package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("http://demo.guru99.com/test/web-table-element.php");
//		No of Rows and Columns
		List<WebElement> Columns = Driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
		System.out.println("No of Columns " + Columns.size()); // Columns Size
		List<WebElement> Rows = Driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		System.out.println("No of Rows " + Rows.size()); // Rows Size
//		Method No-1
		String before_xpath = "/html/body/div[1]/div[3]/div[1]/table/tbody/tr[";
		String after_xpath = "]/td[1]/a";
		for (int i = 1; i <= 26; i++) {
			String name = Driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains("UCO Bank")) {
				Driver.findElement(By.linkText("UCO Bank")).click();
			}
		}
		
		Thread.sleep(5000);
		Driver.quit();
	}
}
