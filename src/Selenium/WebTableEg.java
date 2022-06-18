package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebTableEg {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)   {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get("https://www.w3schools.com/html/html_tables.asp");
//		No of Rows and Columns
		List<WebElement> Columns = Driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/th"));
		System.out.println("No of Columns " + Columns.size()); // Columns Size
		List<WebElement> Rows = Driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		System.out.println("No of Rows " + Rows.size()); // Rows Size
		String Before_Xpath="/html/body/div[7]/div[1]/div[1]/div[3]/div/table/tbody/tr[";
		for(int j=1;j<=Columns.size();j++){
			System.out.println("Column number= " +j);
//		String After_Xpath="]/td[j]";
		for(int i=2;i<=Rows.size();i++) {
			String name=Driver.findElement(By.xpath(Before_Xpath + i + "]/td["+j+"]")).getText();
			
			System.out.println(name);
		}
		
	}
		Driver.quit();
		
	}
	

}


