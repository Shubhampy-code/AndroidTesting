package WebApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebTest extends CapabilityWeb{
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		//I am calling the capability method from the previous class by extending that class using extends method 
		driver = capability();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void rs() {
		driver.get("https://www.google.com/");
		driver.findElement(MobileBy.cssSelector("[class=\"gLFyf\"]")).sendKeys("Masai",Keys.ENTER);
		
	}

}
