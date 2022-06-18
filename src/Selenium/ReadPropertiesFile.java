package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFile {
	static WebDriver Driver;

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\santo\\eclipse-workspacet\\NaveenClass\\src\\Selenium\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.getProperty("Name"));
		System.out.println(prop.getProperty("UserName"));
		String url = prop.getProperty("URL");
		System.out.println(url);
		String browserName = prop.getProperty("Browser");
		System.out.println(browserName);
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
			Driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\geckodriver.exe");
			Driver = new FirefoxDriver();
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\msedgedriver.exe");
			Driver = new EdgeDriver();
		}
		Driver.get(url);
		Driver.findElement(By.xpath(prop.getProperty("firstName_Xpath"))).sendKeys(prop.getProperty("firstName"));
		Driver.findElement(By.xpath(prop.getProperty("lastName_Xpath"))).sendKeys(prop.getProperty("lastName"));
		Driver.findElement(By.xpath(prop.getProperty("date_Xpath"))).sendKeys(prop.getProperty("Date"));
	}
}
