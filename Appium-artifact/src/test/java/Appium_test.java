import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.net.URL;
import java.time.Duration;
import java.io.File;
import java.net.MalformedURLException;


public class Appium_test extends Base_class {

	
		
		@Test
		public void appiumTest() throws InterruptedException, MalformedURLException {
			
			
			driver = init_Appium_Server(); 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			driver.findElement(AppiumBy.accessibilityId("Preference")).click();
			WebElement newWindow = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']"))));
			driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
			WebElement newWindow1 = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("android:id/checkbox"))));

			driver.findElement(By.id("android:id/checkbox")).click();
			WebElement newWindow2 = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout"))));

			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
			WebElement newWindow3 = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("android:id/edit"))));

			driver.findElement(By.id("android:id/edit")).sendKeys("Vodafone-Hostspot");
			WebElement newWindow4 = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("android:id/button1"))));

			driver.findElement(By.id("android:id/button1")).click();
			
			
			//driver.quit();
			//service.close();
			
		
			
	}

}
