package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleFileUpload {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.get("https://demoqa.com/automation-practice-form");
		Driver.findElement(By.id("firstName")).sendKeys("Santosh");
		Driver.findElement(By.id("lastName")).sendKeys("Gadekar");
		Driver.findElement(By.id("userEmail")).sendKeys("Santosh123@gmail.com");
		WebElement g = Driver.findElement(By.id("gender-radio-1"));
		JavascriptExecutor Ex = (JavascriptExecutor) Driver;
		Ex.executeScript("arguments[0].click();", g);
//		ElementClickInterceptedException occurs when the target element 
//		that you want to click is overlaid by some other element in the web page
		Driver.findElement(By.id("userNumber")).sendKeys("8888899999");
		WebElement j = Driver.findElement(By.id("dateOfBirthInput"));
		Ex.executeScript("arguments[0].click();", j);
		String date = "31-January-1992";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		Select selectMonth = new Select(
				Driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]")));
		selectMonth.selectByVisibleText(month);
		Select selectYear = new Select(
				Driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]")));
		selectYear.selectByVisibleText(year);
//		/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[1]   (1,1)
//		/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[1]/div[2]   (1,2)   
//		/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]   (2,1)
//		/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]   (3,2)

		String beforeXpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[1]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[";
		String afterXpath = "]/div[";

		final int totalWeekDays = 7;
		boolean flag=false;
		for (int rowNum = 1; rowNum <= 6; rowNum++) {
			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {
				String dayValue = Driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]"))
						.getText();
				
				if (dayValue.equals(day)) {
					Driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + colNum + "]")).click();
					flag=true;
					break;
				}
			}
			if(flag==true) {
				break;
			}
		}
//		WebElement k = Driver.findElement(By.xpath("//div[@id=\"subjectsContainer\"]"));
//		Ex.executeScript("arguments[0].click();", k);
//		k.sendKeys("Electrical Engineering");
		WebElement h = Driver.findElement(By.id("hobbies-checkbox-1"));
		Ex.executeScript("arguments[0].click();", h);
		String P = "D:\\Mayuri Mobile data\\DCIM\\Camera\\20180225_193050.jpg";
		String A = "At Nighoj, Tal Rahata, Shirdi";
		WebElement Photo = Driver.findElement(By.id("uploadPicture"));
		Photo.sendKeys(P);
		WebElement Address = Driver.findElement(By.id("currentAddress"));
		Address.sendKeys(A);
	}
}
