package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverBasics {

	public static void main(String[] args) {
//		System.setProperty("webdriver.gecko.driver", "E:\\Naveen Automation Selenium Class\\Driver and JAR File\\geckodriver.exe");
//		WebDriver Driver=new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver1 = new ChromeDriver();//Launch the Chrome Browser
		Driver1.get("https://www.selenium.dev/"); //Enter the URL
//		Get the Title
		String t=Driver1.getTitle();
		System.out.println(t);
//		Get Current URL
		System.out.println(Driver1.getCurrentUrl());
		System.out.println();
//		Validation of Title
		if(t.equals("Selenium")) {
			System.out.println("Correct Title");
		}
		else{
			System.out.println("Incorrect Title");
		}
//		Get the Page Source
//		String PS=Driver1.getPageSource();
//		System.out.println(PS);

		Driver1.quit(); //		Quit the Browser
	}
}
