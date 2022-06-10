package Tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.googleSearchPage;

public class TestNG_Demo {
//Type in string, click on search

	private static WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setUpTest() {

		PropertiesFile.getProperties();

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); // initialize chrome webdriver
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}

	@Test
	public static void googleSearch() {

		driver.get("https://google.com"); // go to url
		googleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		googleSearchPage.button_search(driver).sendKeys(Keys.RETURN); // .click() = sendKeys(Keys.RETURN)
		System.out.println("Test Completed Successfully");

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
		PropertiesFile.setProperties();
	}
}
