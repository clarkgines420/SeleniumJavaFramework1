package defaultpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class desiredCapabilitiesDemo {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettigns", true);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(caps); //should be for internet explorer
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.xpath("/html/body")).sendKeys(Keys.RETURN);
	}

}
