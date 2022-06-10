package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("automation testing step by step");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"))
				.sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[1]")).click();
		//driver.findElement(By.linkText("Adolescent Brain Cognitive Development (ABCD) Study")).click();

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver
						.findElement(By.linkText("Everything There Is To Know About Automated Testing"));
				if (linkElement.isEnabled()) {
					System.out.println("Element Found");
				}
				return linkElement;
			}
		});
		
		element.click();

		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

}
