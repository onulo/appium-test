package test.java;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import utility.AbstractTest;

public class GlucksboteAppTest extends AbstractTest {

	@Test
	public void createLottoNormalBarcode() throws InterruptedException, IOException {
		app.mainScreen().createTipTemplate();
		app.mainScreen().selectLottoNormal();
		app.lottoTipScreen().setLottoPicks(Arrays.asList(1, 2, 17, 18, 44, 45));
		app.lottoTipScreen().saveTip();
		app.lottoTipScreen().saveTipSubmit();
		app.betSlip().processTip();
		assertThat("Generated bar code is present", app.betSlip().isQrCodePresent());
	}

	@Test
	public void createLottoQuickBarcode() throws InterruptedException {
		app.mainScreen().createTipTemplate();
		app.mainScreen().selectLottoQuick();
		app.lottoTipScreen().setLottoQuickPickNo("5");
		app.lottoTipScreen().saveTipSubmit();
		app.betSlip().processTip();
		assertThat("Generated bar code is present", app.betSlip().isQrCodePresent());
	}

}
