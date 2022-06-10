package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentReportsWithTestNG {

	
	ExtentReports extent;
	ExtentSparkReporter spark;
	WebDriver driver = null;
	
	@BeforeSuite
	public void setUp() {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);
	}
	
	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void testcase1() {
		
		
		driver.get("https://google.com");
		extent.createTest("Step 0").log(Status.PASS, "Navigated to Google.com");
		extent.createTest("TestNG with Extent").info("Test Started");
		extent.createTest("Step 1").log(Status.PASS, "Test has passed");
		extent.createTest("Step 2").log(Status.INFO, "Information here");
		extent.createTest("Step 3").log(Status.WARNING, "This is a warning");
		extent.createTest("Step 4").log(Status.SKIP, "Test Case Skipped");
		extent.createTest("Step 5").log(Status.FAIL,"Failed");
		extent.createTest("Step 6").addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@Test
	public void testcase2() {
		
		extent.createTest("TestNG with Extent").info("Test Started");
		extent.createTest("Step 1").log(Status.PASS, "Test has passed");
		extent.createTest("Step 2").log(Status.INFO, "Information here");
		extent.createTest("Step 3").log(Status.WARNING, "This is a warning");
		extent.createTest("Step 4").log(Status.SKIP, "Test Case Skipped");
		extent.createTest("Step 5").log(Status.FAIL,"Failed");
		extent.createTest("Step 6").addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterTest
	public void tearDownTest() {
	 driver.close();
	 driver.quit();
	 System.out.println("Test Completed Successfully");
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}

}
