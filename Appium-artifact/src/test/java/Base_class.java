import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Base_class {
	private static final String COUNTRY_NAME_ID = "android:id/text1";
	private static final String PRODUCT_NAME_ID = "com.androidsample.generalstore:id/productName";
	private static final String ADD_CART_ID = "com.androidsample.generalstore:id/productAddCart";
	private static final String PRODUCT_PRICE_ID = "com.androidsample.generalstore:id/productPrice";
	private static final String CHECKOUT_PRICE_ID = "com.androidsample.generalstore:id/totalAmountLbl";
	private static final String TOAST_MESSAGE = "(//android.widget.Toast)[1]";



	AndroidDriver driver;
	public AndroidDriver init_Appium_Server() throws MalformedURLException {
		UiAutomator2Options caps = new UiAutomator2Options();


		caps.setDeviceName("Pixel 4 (Edited) API 34");
		caps.setApp("//Users//abubakar//eclipse/Appium-artifact//src//test//java//resources//General-Store.apk");
		URL url = new URL("http://localhost:4723/wd/hub");
		return driver = new AndroidDriver(url, caps);


	}

	public void scroll_until(String text) {

		driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", text)));

}
	public void waitForElementById(String Id, int duration) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id(Id))));
	}
	public String getToastMessage() {
		waitForElementByXpath(TOAST_MESSAGE, 10);
		String toastMessage = driver.findElement(By.xpath(TOAST_MESSAGE)).getAttribute("name");
		return toastMessage;
		
	}
	public void waitForElementByXpath(String Xpath, int duration) {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(Xpath))));
		}
	public void clickOnElementById(String Id) {
		driver.findElement(By.id(Id)).click();

	}
	public void clickOnElementByClassName(String className) {
		driver.findElement(By.className(className)).click();

	}
	public void clickOnCountry(String string) {
		List<WebElement> Elements = driver.findElements(By.id(COUNTRY_NAME_ID));

		Elements.stream()
	    .filter(Element -> string.equals(Element.getAttribute("text")))
	    .findFirst() // This gets the first match.
	    .ifPresent(WebElement::click);

	}
	public void enterText(String ID, String Text) {
		driver.findElement(By.id(ID)).sendKeys(Text);

	}
	public Map<String, Float> getProductsAndPrices(List<String> testProducts) {
		Map<String, Float> productPrices = new HashMap<>();
		for (String testProduct : testProducts) {
		    scroll_until(testProduct); // method in my base class
		    List<WebElement> productNames = driver.findElements(By.id(PRODUCT_NAME_ID));
		    OptionalInt indexOpt = IntStream.range(0, productNames.size())
		        .filter(i -> testProduct.equals(productNames.get(i).getAttribute("text")))
		        .findFirst();
		    if (indexOpt.isPresent()) {
		        int index = indexOpt.getAsInt();
		        System.out.println("Element found at index: " + index);
		        driver.findElements(By.id(ADD_CART_ID)).get(index).click();

		        // get the product price as an integer
		        String priceText = driver.findElements(By.id(PRODUCT_PRICE_ID)).get(index).getText();
		        float price = Float.parseFloat(priceText.replaceAll("[^0-9.]", ""));// remove non-digit characters

		        // add to the map
		        productPrices.put(testProduct, price);
		    } else {
		        System.out.println("Element not found");
		    }
		}
		return productPrices;
	}
	public void checkPricesAtCheckout(Map<String, Float> productPrices) {
		for (Map.Entry<String, Float> entry : productPrices.entrySet()) {
		    String productName = entry.getKey();
		    float productPrice = entry.getValue();

		    // Get the name and price from the checkout page using your product locator strategy
		    List<WebElement> checkoutproductNames = driver.findElements(By.id(PRODUCT_NAME_ID));
		    OptionalInt indexOpt = IntStream.range(0, checkoutproductNames.size())
		        .filter(i -> productName.equals(checkoutproductNames.get(i).getAttribute("text")))
		        .findFirst();
		    if (indexOpt.isPresent()) {
		        int index = indexOpt.getAsInt();
		        System.out.println("Element found at index: " + index);

		        // get the product price as an integer
		        String checkoutPriceText = driver.findElements(By.id(PRODUCT_PRICE_ID)).get(index).getText();
		        System.out.println("checkoutPriceText: " + checkoutPriceText);
		        float checkoutPrice = Float.parseFloat(checkoutPriceText.replaceAll("[^0-9.]", ""));
		        System.out.println("Parsed checkoutPrice: " + checkoutPrice);
		        Assert.assertEquals(productPrice, checkoutPrice);

		    } else {
		        System.out.println("Element not found");
		    }

		}

	}
	public float getTotalCartPrice(Map<String, Float> productPrices) {
		float totalCartPrice = (float) productPrices.values().stream()
			    .mapToDouble(Float::doubleValue)
			    .sum();
		return totalCartPrice;
	}

    public float getCheckoutPrice() {
    	String checkoutPriceUIText = driver.findElement(By.id(CHECKOUT_PRICE_ID)).getAttribute("text");
        float checkoutPriceUI = Float.parseFloat(checkoutPriceUIText.replaceAll("[^0-9.]", ""));// remove non-digit characters
		return checkoutPriceUI;
	}


}
