package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.googleSearchPage;

public class googleSearchTest {
//Type in string, click on search
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();

	}
	
	
public static void googleSearch() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(); //initialize chrome webdriver
	driver.get("https://google.com");  //go to url
	googleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
	googleSearchPage.button_search(driver).sendKeys(Keys.RETURN); //.click() = sendKeys(Keys.RETURN)
	System.out.println("Test Completed Successfully");
	
}

}
