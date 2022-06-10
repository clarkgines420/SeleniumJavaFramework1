package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//to implement multiple listeners, use diff method, refer to documentation
//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo2 {

	@Test
	public void test4() {
		System.out.println("I am inside Test 4");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();


		driver.get("https://latraining.cloudinsurer.com/PORTAL/common/jsp/portal.jsp");
		driver.manage().window().maximize();
		driver.findElement(By.id("j_username_input")).sendKeys("Testuser");
		driver.findElement(By.id("j_password_input")).sendKeys("Majesco");
		driver.findElement(By.xpath("//*[@id=\"loginSubmit_btn\"]/spa")).click();
		driver.findElement(By.xpath("/html/body/form/div/table/tbody/tr[4]/td/ul/li[2]/i")).click();
		driver.close();

	}

	@Test
	public void test5() {
		System.out.println("I am inside Test 5");
	}

	@Test
	public void test6() {
		System.out.println("I am inside Test 6");
	}

}
