package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitDemo {

	public static WebDriver driver = null;

	public static void main(String[] args) {
		seleniumWaits();
	}

	public static void seleniumWaits() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//250ms is the default poll rate, so 250ms until 10s
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"))
				.sendKeys(Keys.RETURN);
		WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
		driver.findElement(By.name("abcd")).click();
		System.out.println(wait.getText());
		//WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		  //      .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		driver.close();
		driver.quit();
	}
}
