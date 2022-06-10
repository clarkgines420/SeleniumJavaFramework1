package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGMultiBrowserDemo {

	WebDriver driver = null;

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println("Browser name is: " + browserName);
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.out.println("Browser name is: " + browserName);
			WebDriverManager.firefoxdriver().setup();
		    driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.out.println("Browser name is: " + browserName);
			WebDriverManager.edgedriver().setup();
		    driver = new EdgeDriver();
		}
	}

	@Test
	public void test1() throws InterruptedException {

		driver.get("https://google.com");
		System.out.println("Thread id: "+Thread.currentThread().getId());
		Thread.sleep(4000);

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		System.out.println("Test Completed Successfully");

	}

}
