import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Happy_Path extends Base_class {

	private static final String SPINNER_COUNTRY_ID = "com.androidsample.generalstore:id/spinnerCountry";
	private static final String USER_NAME_ID="com.androidsample.generalstore:id/nameField";
	private static final String LETS_SHOP_BTN_ID="com.androidsample.generalstore:id/btnLetsShop";
	private static final String APPBAR_CART_ID = "com.androidsample.generalstore:id/appbar_btn_cart";
	private static final String CHECKOUT_CHECKBOX_ID = "android.widget.CheckBox";
	private static final String CHECKOUT_BUTTON_ID="com.androidsample.generalstore:id/btnProceed";
	// More constants for the other IDs...
	public Utils utils;
	@Test
	public void store_Scenarios() throws InterruptedException, MalformedURLException {
		driver = init_Appium_Server();
		utils = Utils.initialize(driver);
		waitForElementById(SPINNER_COUNTRY_ID, 10);

		utils.clickOnElementById(SPINNER_COUNTRY_ID);
		utils.scroll_until("Angola");
		clickOnCountry("Angola");
		
		

		enterText(USER_NAME_ID, "Abu Bakar");
		utils.clickOnElementById(LETS_SHOP_BTN_ID);

		Thread.sleep(5000);
		List<String> testProducts = Arrays.asList("Air Jordan 9 Retro","Converse All Star");
		Map<String, Float> productPrices = getProductsAndPrices(testProducts);

		utils.clickOnElementById(APPBAR_CART_ID);
		Thread.sleep(5000);
		checkPricesAtCheckout(productPrices);

		float totalCartPrice = getTotalCartPrice(productPrices);
		float checkoutPriceUI = getCheckoutPrice();

		Assert.assertEquals(totalCartPrice, checkoutPriceUI);

		utils.clickOnElementByClassName(CHECKOUT_CHECKBOX_ID);
		utils.clickOnElementById(CHECKOUT_BUTTON_ID);
	}


}