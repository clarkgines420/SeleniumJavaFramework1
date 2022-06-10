package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.googleSearchPage;

public class TestNG_Demo2 {
//Type in string, click on search
	
	private static WebDriver driver = null;
	
@BeforeTest
public void setUpTest() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(); //initialize chrome webdriver
}
	
@Test	
public static void googleSearch2() {
	
	driver.get("https://google.com");  //go to url
	googleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
	googleSearchPage.button_search(driver).sendKeys(Keys.RETURN); //.click() = sendKeys(Keys.RETURN)
	System.out.println("Test Completed Successfully");
	
}

@Test	
public static void googleSearch3() {
	
	driver.get("https://google.com");  //go to url
	googleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
	googleSearchPage.button_search(driver).sendKeys(Keys.RETURN); //.click() = sendKeys(Keys.RETURN)
	System.out.println("Test Completed Successfully");
	
}




@AfterTest
public void tearDownTest() {
 driver.close();
 driver.quit();
 System.out.println("Test Completed Successfully");
}
}
