package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.googleSearchPageObjects;

public class googleSearchPageTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //initialize chrome webdriver
		
		
		googleSearchPageObjects searchPageObj = new googleSearchPageObjects(driver);
		
		driver.get("https://google.com");  //go to url
		searchPageObj.setTextInSearchBox("A B C D");
		
		searchPageObj.clickSearchButton();
		
		//driver.close();
		
	}
}
