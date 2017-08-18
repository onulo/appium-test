package screen;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainScreen extends AbstractScreen {

	private static Logger log = Logger.getLogger(MainScreen.class.getName());

	@AndroidFindBy(id = "at.lotterien.app:id/btn_add_tip")
	private WebElement createTipBtn;

	@AndroidFindBy(id = "at.lotterien.app:id/buttonNormal")
	private WebElement lottoNormalBtn;

	@AndroidFindBy(id = "at.lotterien.app:id/buttonQuick")
	private WebElement lottoQuickBtn;

	public MainScreen(AndroidDriver<WebElement> driver) {
		super(driver);
	}

	public void createTipTemplate() {
		waitForElementElement(createTipBtn);
		log.info("Clicking on Create tip");
		createTipBtn.click();
	}

	public void selectLottoNormal() {
		waitForElementElement(lottoNormalBtn);
		log.info("Clicking on Lotto Normal");
		lottoNormalBtn.click();
	}
	
	public void selectLottoQuick() {
		waitForElementElement(lottoQuickBtn);
		log.info("Clicking on Lotto Quick");
		lottoQuickBtn.click();
	}

}
