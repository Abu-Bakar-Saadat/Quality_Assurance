
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Online_Store extends Base_class {

	@Test
	public void store_Scenarios() throws InterruptedException, MalformedURLException {
		
		
		driver = init_Appium_Server(); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newWindow1 = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("com.androidsample.generalstore:id/spinnerCountry"))));

		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		scroll_until("Angola");
		List<WebElement> Elements = driver.findElements(By.id("android:id/text1"));
		
		Elements.stream()
	    .filter(Element -> "Angola".equals(Element.getAttribute("text")))
	    .findFirst() // This gets the first match.
	    .ifPresent(WebElement::click); // This clicks on the element if one was found.
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Abu Bakar");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		// Find all RelativeLayout elements representing items.
		Thread.sleep(5000);
		List<String> testProducts = Arrays.asList("Air Jordan 9 Retro","Converse All Star"); // add your products here
		Map<String, Float> productPrices = new HashMap<>();
		

		for (String testProduct : testProducts) {
		    scroll_until(testProduct); // method in my base class
		    List<WebElement> productNames = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		    OptionalInt indexOpt = IntStream.range(0, productNames.size())
		        .filter(i -> testProduct.equals(productNames.get(i).getAttribute("text")))
		        .findFirst();
		    if (indexOpt.isPresent()) {
		        int index = indexOpt.getAsInt();
		        System.out.println("Element found at index: " + index);
		        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(index).click();

		        // get the product price as an integer
		        String priceText = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(index).getText();
		        float price = Float.parseFloat(priceText.replaceAll("[^0-9.]", ""));// remove non-digit characters

		        // add to the map
		        productPrices.put(testProduct, price);
		    } else {
		        System.out.println("Element not found");
		    }
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		float checkoutTotal=0;
		float totalCartPrice = (float) productPrices.values().stream()
			    .mapToDouble(Float::doubleValue)
			    .sum();
		for (Map.Entry<String, Float> entry : productPrices.entrySet()) {
		    String productName = entry.getKey();
		    float productPrice = entry.getValue();

		    // Get the name and price from the checkout page using your product locator strategy
		    List<WebElement> checkoutproductNames = driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
		    OptionalInt indexOpt = IntStream.range(0, checkoutproductNames.size())
		        .filter(i -> productName.equals(checkoutproductNames.get(i).getAttribute("text")))
		        .findFirst();
		    if (indexOpt.isPresent()) {
		        int index = indexOpt.getAsInt();
		        System.out.println("Element found at index: " + index);

		        // get the product price as an integer
		        String checkoutPriceText = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(index).getText();
		        System.out.println("checkoutPriceText: " + checkoutPriceText);
		        float checkoutPrice = Float.parseFloat(checkoutPriceText.replaceAll("[^0-9.]", ""));
		        System.out.println("Parsed checkoutPrice: " + checkoutPrice);
		        Assert.assertEquals(productPrice, checkoutPrice);
		    	checkoutTotal=	checkoutTotal+checkoutPrice;
		        
		    } else {
		        System.out.println("Element not found");
		    }
		    
		}
		String checkoutPriceUIText = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getAttribute("text");
        float checkoutPriceUI = Float.parseFloat(checkoutPriceUIText.replaceAll("[^0-9.]", ""));// remove non-digit characters
		
		Assert.assertEquals(totalCartPrice, checkoutTotal);
		Assert.assertEquals(totalCartPrice, checkoutPriceUI);
		
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		
		
		   
		    
		}
}




