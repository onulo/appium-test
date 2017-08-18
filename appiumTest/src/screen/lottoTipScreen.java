package screen;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class lottoTipScreen extends AbstractScreen {

	private static Logger log = Logger.getLogger(lottoTipScreen.class.getName());

	@AndroidFindBy(id = "at.lotterien.app:id/value")
	private List<WebElement> lottoPicks;

	@AndroidFindBy(id = "at.lotterien.app:id/save")
	private WebElement saveTip;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement okButton;
	
	@AndroidFindBy(className = "android.widget.NumberPicker")
	private MobileElement quickNumberPicker;
	
	@AndroidFindBy(className = "android:id/button1")
	private MobileElement quickNumberPickerOkBtn;

	public lottoTipScreen(AndroidDriver<WebElement> driver) {
		super(driver);
	}
	
	public void setLottoQuickPickNo(String tipNo) throws InterruptedException{
		
		//TODO Refactor dont use thread.sleep
		
		waitForElementElement(quickNumberPicker);
		List<MobileElement> buttons = quickNumberPicker.findElementsByClassName("android.widget.Button");
		MobileElement actualSelection = quickNumberPicker.findElementById("android:id/numberpicker_input");
		log.info("Selecting quick tips...");
		while(!actualSelection.getText().equals(tipNo)){
			buttons.get(0).click();
			Thread.sleep(500);
		}
		log.info("Selected quick tip: " + actualSelection.getText());
		actualSelection.setValue("5");
		saveTipSubmit();
		
	}
	
	public void setLottoPicks(List<Integer> picks) {
		log.info("Selecting pick...");
		picks.stream().forEach(p -> {
			waitForElementElement(lottoPicks.get(p - 1));
			lottoPicks.get(p - 1).click();
			log.info("Selected pick: " + p);
		});
	}

	public void saveTip() {
		waitForElementElement(saveTip);
		log.info("Saving Tip");
		saveTip.click();
	}

	public void saveTipSubmit() {
		waitForElementElement(okButton);
		log.info("Submitting tip...");
		okButton.click();
	}

}
