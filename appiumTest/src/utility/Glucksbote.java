package utility;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import screen.BetSlip;
import screen.lottoTipScreen;
import screen.MainScreen;

public class Glucksbote {
	private final AndroidDriver<WebElement> driver;

	public Glucksbote(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	public MainScreen mainScreen(){
		return new MainScreen(driver);
	}
	
	public lottoTipScreen lottoTipScreen(){
		return new lottoTipScreen(driver);
	}
	
	public BetSlip betSlip(){
		return new BetSlip(driver);
	}

}
