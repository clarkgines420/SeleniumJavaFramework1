package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class googleSearchPageObjects {
	
	//create constructor so that the driver instance that will be used by this class is the one from the test class
	
	public googleSearchPageObjects(WebDriver driver){
		this.driver =  driver; //this.driver is used because the diver that we take from the argument has the same name as the driver that we initialize here.
	}//(WebDriver driver1)
	// driver = driver1; 
	
	WebDriver driver = null;
	By textbox_search = By.name("q");
	By button_search = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]");
	
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
	}
	
	
}
