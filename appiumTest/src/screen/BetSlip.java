package screen;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BetSlip extends AbstractScreen {

	private static Logger log = Logger.getLogger(BetSlip.class.getName());

	@AndroidFindBy(id = "at.lotterien.app:id/qrCode")
	private MobileElement qrCode;

	// @AndroidFindBy(uiAutomator = "new
	// UiSelector().resourceId(\"at.lotterien.app:id/toScan\")")
	// private WebElement submit;

	@AndroidFindBy(id = "at.lotterien.app:id/toScan")
	private WebElement submit;

	public BetSlip(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void processTip() {
		waitForElementElement(submit);
		log.info("Clicking to Tippabgabe ");
		submit.click();
	}

	public boolean isQrCodePresent() {
		log.info("Checking presence of qr code...");
		waitForElementElement(qrCode);
		return qrCode.isDisplayed() && qrCode.isEnabled();
	}

}
