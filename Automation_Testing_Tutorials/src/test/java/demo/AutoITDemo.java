package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITDemo {

	public static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		test1();

	}

	public static void test1() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("myFile"))).click().build().perform();
		Runtime.getRuntime().exec("C:\\Users\\ClarkGines\\Desktop\\FileUploadScript");
		Thread.sleep(3000);
		driver.close();
		driver.quit();

//		Actions builder = new Actions(driver);
//		builder.moveToElement(driver.findElement(By.name("photofile"))).click().build().perform();		
//		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.name("Submit")).click();
//		driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");

	}

}
