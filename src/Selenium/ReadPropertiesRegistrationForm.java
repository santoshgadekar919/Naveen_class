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
import org.openqa.selenium.support.ui.Select;

public class ReadPropertiesRegistrationForm {
	static WebDriver Driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, InterruptedException {
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
		Driver.findElement(By.id(Prop.getProperty("id_email_create"))).sendKeys(Prop.getProperty("email"));
		Driver.findElement(By.id(Prop.getProperty("id_btn_submit"))).click();
		Driver.findElement(By.id(Prop.getProperty("id_radio_sex"))).click();
		Driver.findElement(By.id(Prop.getProperty("id_firstname"))).sendKeys(Prop.getProperty("fname"));
		Driver.findElement(By.id(Prop.getProperty("id_lastname"))).sendKeys(Prop.getProperty("lname"));
		Driver.findElement(By.id(Prop.getProperty("id_password"))).sendKeys(Prop.getProperty("pass"));
		Select date = new Select(Driver.findElement(By.id(Prop.getProperty("id_days"))));
		date.selectByValue(Prop.getProperty("BirthDate"));
		Select month = new Select(Driver.findElement(By.id(Prop.getProperty("id_months"))));
		month.selectByValue(Prop.getProperty("BirthMonth"));
		Select year = new Select(Driver.findElement(By.id(Prop.getProperty("id_years"))));
		year.selectByValue(Prop.getProperty("BirthYear"));
		Driver.findElement(By.id(Prop.getProperty("id_Rd_newl"))).click();
		Driver.findElement(By.id(Prop.getProperty("id_Rd_opt"))).click();
		Driver.findElement(By.id(Prop.getProperty("id_companyName"))).sendKeys(Prop.getProperty("CompanyName"));
		Driver.findElement(By.id(Prop.getProperty("id_add"))).sendKeys(Prop.getProperty("Place"));
		Driver.findElement(By.id(Prop.getProperty("id_city"))).sendKeys(Prop.getProperty("City"));
		Select state = new Select(Driver.findElement(By.id(Prop.getProperty("id_st"))));
		state.selectByVisibleText(Prop.getProperty("State"));
		Driver.findElement(By.id(Prop.getProperty("id_post"))).sendKeys(Prop.getProperty("PostCode"));
		Driver.findElement(By.id(Prop.getProperty("id_oth_inf"))).sendKeys(Prop.getProperty("Information"));
		Driver.findElement(By.id(Prop.getProperty("id_mob"))).sendKeys(Prop.getProperty("Mobile"));
		Driver.findElement(By.id(Prop.getProperty("id_btn_SubmitForm"))).click();
		Thread.sleep(5000);
		Driver.quit();
	}
}
