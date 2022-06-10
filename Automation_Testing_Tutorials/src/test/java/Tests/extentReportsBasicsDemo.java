package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;




public class extentReportsBasicsDemo {

	//------------------------------Setup-------------------------------
	private static WebDriver driver = null;
	//------------------------------Setup-------------------------------
	
	
	public static void main(String[] args) {
		
		//------------------------------Extent Reports Setup-------------------------------
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);
		//------------------------------Extent Reports Setup-------------------------------
		
		//------------------------------Setup-------------------------------
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//------------------------------Setup-------------------------------
	   
		
		//extent.createTest("ScreenCapture").addScreenCaptureFromPath("extent.png");
		
		
		//------------------------------Test--------------------------------
		extent.createTest("MyFirstTest").log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com/");
		extent.createTest("MyFirstTest").log(Status.PASS, "Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation Testing Step by Step");
		extent.createTest("MyFirstTest").log(Status.PASS, "Entered Text in Searchbox");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]")).click();
		extent.createTest("MyFirstTest").log(Status.PASS, "Pressed enter on keyboard");
		
		driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[1]")).click();
		extent.createTest("MyFirstTest").log(Status.PASS, "Clicked next page");
		driver.findElement(By.id("logo")).click();
		extent.createTest("MyFirstTest").log(Status.FAIL, "Clicked on logo");
		//------------------------------Test--------------------------------
		
		
		driver.close();
		
		driver.quit();
	
	
	
		extent.flush();
	}

}
