package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {

		@SuppressWarnings("deprecation")
		public static void main(String[] args) throws IOException {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
			WebDriver Driver = new ChromeDriver();
			Driver.manage().window().maximize();
			Driver.manage().deleteAllCookies();
			Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Driver.get("http://automationpractice.com/index.php");
			File scrFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
            //The below method will save the screen shot in destination directory with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("E:\\Naveen Automation Selenium Class\\Error ScreenShot\\screenshot.png"));
			Driver.quit();
	}

}
