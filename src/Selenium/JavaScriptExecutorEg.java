package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptExecutorEg {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, InterruptedException {
		Properties Prop = new Properties();
		FileInputStream Ip = new FileInputStream(
				"C:\\Users\\santo\\eclipse-workspacet\\NaveenClass\\src\\Selenium\\Automation.properties");
		Prop.load(Ip);
		System.setProperty("webdriver.chrome.driver",
				"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.get(Prop.getProperty("URL"));
		WebElement email=Driver.findElement(By.id(Prop.getProperty("id_email")));
		flash(email, Driver); //Highlight the selected element with green color
		email.sendKeys(Prop.getProperty("email"));
		Driver.findElement(By.id(Prop.getProperty("id_passwd"))).sendKeys(Prop.getProperty("pass"));
		WebElement loginbtn=Driver.findElement(By.id(Prop.getProperty("id_1111")));
		drawBorder(loginbtn, Driver); //Create the border around the selected element with red color
		File scrFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in destination directory with name "screenshot.png"
        FileUtils.copyFile(scrFile, new File("E:\\Naveen Automation Selenium Class\\Error ScreenShot\\screenshot11.png"));
        generateAlert(Driver,"There is a problem in the Login button");//This method is used to generate the user defined alert
//        Now accept alert here
        Alert alt=Driver.switchTo().alert();
        alt.accept();
        clickElementByJS(Driver,loginbtn);//This method is used to click on the selected element
//		Refresh the Webpage
//		Driver.navigate().refresh();
		refreshWebpage(Driver);
		//This method is used to get the title of the WebPage
		System.out.println(getTitleJs(Driver));
		//get the page text 
		System.out.println(getPageInnerTextJs(Driver));
		//to scroll down to the bottom
//		scrollPageDownJs(Driver);
		
		
		WebElement myAdd=Driver.findElement(By.linkText("My credit slips"));
		//This method is used to scroll down to until the element is visible
		scrollIntoView(myAdd, Driver);
		Thread.sleep(5000);

		Driver.quit();
	}
	
	public static void flash(WebElement element,WebDriver Driver) {
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0; i<100;i++) {
			changeColor("rgb(0, 200, 0)", element, Driver);
			changeColor(bgcolor, element, Driver);
		}
	}
	public static void changeColor(String color, WebElement element,WebDriver Driver) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		try {
			Thread.sleep(50);
		}catch(InterruptedException e) {
			
		}
	}
	public static void drawBorder(WebElement element, WebDriver Driver) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public static void generateAlert(WebDriver Driver, String message) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("alert('"+message+"')");
	}
	public static void clickElementByJS(WebDriver Driver, WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("arguments[0].click();", element);
	}
	public static void refreshWebpage(WebDriver Driver) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("history.go(0)");
	}
	public static String getTitleJs(WebDriver Driver) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	public static String getPageInnerTextJs(WebDriver Driver) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	public static void scrollPageDownJs(WebDriver Driver) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollIntoView(WebElement element, WebDriver Driver) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
