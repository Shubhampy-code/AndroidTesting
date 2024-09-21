package WebApp;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.Immutable;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CapabilityWeb {
	
	public static AndroidDriver<AndroidElement> capability() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "my_emulator");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C://Users//Shubham Shrivastava//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");
		
		dc.setCapability("appium:chromeOptions", ImmutableMap.of("w3c",false));
		//for android we have android driver //  we have androidelement
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		return driver;
	}

}
