package HybridApp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GenralStore extends Hybrid_Capability{
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		//I am calling the capability method from the previous class by extending that class using extends method 
		
		driver = capability();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void gs() {
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"))")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shubham");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//driver.findElements(MobileBy.className("android.widget.TextView")).get(0).click();
		
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		String price1 = driver.findElement(MobileBy.xpath("//*[@text='$160.97']")).getText();
		System.out.println(price1);
		
		String price2 = driver.findElement(MobileBy.xpath("//*[@text='$120.0']")).getText();
		
		String totalPrice = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println(totalPrice);
		
		String product1 = price1.substring(1);
		String product2 = price2.substring(1);
		
		totalPrice = totalPrice.substring(1);
		
		System.out.println(product1);
		System.out.println(product2);
		System.out.println(totalPrice);
		
		Double p1 = Double.parseDouble(product1);
		Double p2 = Double.parseDouble(product2);
		Double tp = Double.parseDouble(totalPrice);
		
		Double total = p1+p2;
		System.out.println(total);
		
	}

}
