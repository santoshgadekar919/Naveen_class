package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTableFreeCRM {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		Driver.get("https://ui.cogmento.com");
		Driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("santoshgadekarjscoe@gmail.com");
		Driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Santosh24#");
		Driver.findElement(By.xpath("//*[contains(text(),\"Login\")]")).click();
		Actions action=new Actions(Driver);
		action.moveToElement(Driver.findElement(By.xpath("//i[@class=\"users icon\"]"))).build().perform();
		Driver.findElement(By.linkText("Contacts")).click();

//		No of Rows and Columns
		List<WebElement> Col = Driver.findElements(By.xpath("//table[@class=\"ui celled sortable striped table custom-grid\"]/thead/tr/th"));
		System.out.println("No of Columns " + Col.size()); // Columns Size
		List<WebElement> Rows = Driver.findElements(By.xpath("//table[@class=\"ui celled sortable striped table custom-grid\"]/tbody/tr"));
		System.out.println("No of Rows " + Rows.size()); // Rows Size
		
//		Method No-1  
//		String before_xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[";
//		String after_xpath = "]/td[2]";
//		int j=4;
//		String name1 = Driver.findElement(By.xpath(before_xpath + j + after_xpath)).getText();
//		System.out.println(name1);
//		for (int i = 1; i<=Rows.size(); i++) {
//			String name = Driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			if (name.contains("FFF FFFF")) {
//				WebElement contact=Driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td[2]"));
//				clickElementByJS(Driver,contact);
//				Thread.sleep(5000);
//			}
//		}
//		Thread.sleep(5000);
//		Driver.quit();
//	}
		
		WebElement contact=Driver.findElement(By.xpath("//a[text()=\"hhjjjhbhbh czczczc ddsccz\"]//parent::td//preceding-sibling::td//input[@name=\"id\"]"));
		clickElementByJS(Driver,contact);
		Thread.sleep(5000);
		Driver.quit();
	}
	public static void clickElementByJS(WebDriver Driver, WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("arguments[0].click();", element);
	}
	
//	This is the program for Webtable at FREECRM Website ggfgfdjkfhjfhdjj
}
