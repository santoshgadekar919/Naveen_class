package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesEg2 {
	static WebDriver Driver;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException{
		Properties Prop = new Properties();
		FileInputStream Ip = new FileInputStream(
				"C:\\Users\\santo\\eclipse-workspacet\\NaveenClass\\src\\Selenium\\Automation.properties");
		Prop.load(Ip);
		if (Prop.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
			Driver = new ChromeDriver();
		} else if (Prop.getProperty("browser").equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\geckodriver.exe");
			Driver = new FirefoxDriver();
		} else if (Prop.getProperty("browser").equals("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\msedgedriver.exe");
			Driver = new EdgeDriver();
		}	
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get(Prop.getProperty("URL"));
		System.out.println("Before Login Title---------" +Driver.getTitle());
		Driver.findElement(By.id(Prop.getProperty("id_email"))).sendKeys(Prop.getProperty("email"));
		Driver.findElement(By.id(Prop.getProperty("id_passwd"))).sendKeys(Prop.getProperty("pass"));
		Driver.findElement(By.id(Prop.getProperty("id_1111"))).click();
		System.out.println("After Login Title--------" +Driver.getTitle());
		Driver.quit();
	}
}
