package utility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;

import config.Environment;
import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractTest {

	private AndroidDriver<WebElement> driver;
	protected Glucksbote app;

	@Before
	public void init() throws FileNotFoundException, IOException {

		Environment env = Environment.getInstance();
		WebDriverFactory factory = new WebDriverFactory();

		if (env.getExecuteLocal().equals("true")) {
			driver = factory.getDriver("LOCAL_DRIVER");
			
		} else if (env.getExecuteRemote().equals("true")) {
			driver = factory.getDriver("REMOTE_DRIVER");

		} else if (env.getExecuteRemoteSauceLab().equals("true")) {
			driver = factory.getDriver("REMOTE_SAUCELABS_DRIVER");
			
		}
		//TODO add exception

		app = new Glucksbote(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
