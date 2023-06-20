import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Missing_Username_Test extends Base_class {
	
	private static final String LETS_SHOP_BTN_ID="com.androidsample.generalstore:id/btnLetsShop";
	private static final String TOAST_MESSAGE="Please enter your name";

	@Test

	public void Toast_message_test() throws InterruptedException, MalformedURLException {
		driver = init_Appium_Server();
		waitForElementById(LETS_SHOP_BTN_ID, 10);
		clickOnElementById(LETS_SHOP_BTN_ID);
		String toastMessage = getToastMessage();
		Assert.assertEquals(toastMessage, TOAST_MESSAGE);
		

}
}