package nativeapp;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;

import javax.lang.model.element.Element;
import javax.swing.table.TableColumn;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;;


public class apidemos extends cap{
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		//I am calling the capability method from the previous class by extending that class using extends method 
		
		driver = capability();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void tc() {
		System.out.println("Api Demos Opened");
		driver.findElement(MobileBy.AccessibilityId("Accessibility")).click();
		driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();
	}
	
	@Test
	public void prefernce() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
		//there are multiple ways of using the text
		// another way of using the text that u can follow easily
		// we need two things if we have to click on anything using tex attribute
		// 1. AndroidUIAutomator 2. UiSelector
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Shubham");
		driver.hideKeyboard();
		driver.findElement(MobileBy.id("android:id/button2")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(4000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	@Test
	public void notification() {
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	@Test
	public void scrolll() {
		// if you want to scroll you new three things 
		//1. Uiscrollable
		//2. UiSelector
		//3. scrollIntoView
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))")).click();
		
	}
	
	@Test
	public void longgPress() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		
		AndroidElement cat = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Cat Names\")"));
		//longgpress comes under what?? --> touch and tap
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(cat)).withDuration(ofSeconds(5))).release().perform();
	}
	
	@Test
	public void swiipee() {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("12"));
		AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("5"));
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();

	}
	
	@Test
	public void dragAndDrop() {
		
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement ele1 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		AndroidElement ele2 = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	}
	
	@Test
	
	public void sendMassage() throws InterruptedException {
		
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hi");
		driver.findElement(MobileBy.AccessibilityId("Send")).click();
		
		driver.activateApp("com.google.android.apps.messaging");
		Thread.sleep(5000);
		String msg = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		
		System.out.println(msg);
		
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		
		
		
		
	}
	
}
