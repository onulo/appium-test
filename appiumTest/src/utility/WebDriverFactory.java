package utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.Environment;
import io.appium.java_client.android.AndroidDriver;

public class WebDriverFactory {
	
	private static Logger log = Logger.getLogger(AbstractTest.class.getName());

	public AndroidDriver<WebElement> getDriver(String driverType) throws FileNotFoundException, IOException{
		Environment env = Environment.getInstance();
		
		switch(driverType){
		case "LOCAL_DRIVER":
			String localUrl = env.getLocalAppiumServerUrl();
			log.info("Connecting to local Appium server: " + localUrl);
			return new AndroidDriver<WebElement>(new URL(localUrl), getCapabilities(env));
			
		case "REMOTE_DRIVER":
			String remoteUrl = env.getRemoteGridUrl();
			log.info("Connecting to remote Selenium Grid server: " + remoteUrl);
			return new AndroidDriver<WebElement>(new URL(remoteUrl), getCapabilities(env));
			
		case "REMOTE_SAUCELABS_DRIVER":
			String remoteSauceLabUrl = env.getRemoteSauceLabServerUrl();
			log.info("Connecting to remote SauceLab server: " + remoteSauceLabUrl);
			return new AndroidDriver<>(new URL(remoteSauceLabUrl), getSauceLabCapabilities(env));
		}
		return null;
	}
	
	private DesiredCapabilities getSauceLabCapabilities(Environment env) throws FileNotFoundException, IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = DesiredCapabilities.android();
		capabilities.setCapability("name", "TestExample");
		capabilities.setCapability("appiumVersion", "1.6.5");
		capabilities.setCapability("deviceName","Samsung Galaxy S4 Emulator");
		capabilities.setCapability("browserName", "");
		capabilities.setCapability("platformVersion","4.4");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("clearSystemFiles",true);
		capabilities.setCapability("appPackage", env.getDefaultAppPackage());
		capabilities.setCapability("appActivity", "at.lotterien.app.ui.activity.MainActivity");
		capabilities.setCapability("app","https://www.dropbox.com/s/gh6xruliu8uzzo7/glucksbote.apk?dl=0");
		return capabilities;
	}
	
	private DesiredCapabilities getCapabilities(Environment env) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Galaxy S6");
		capabilities.setCapability("appPackage", env.getDefaultAppPackage());
		capabilities.setCapability("appActivity", "at.lotterien.app.ui.activity.MainActivity");
		capabilities.setCapability("udid", "0715f73976c73d32");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("automationName", "uiautomator2");
		return capabilities;
	}

	
}



