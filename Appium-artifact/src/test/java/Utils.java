import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumBy;

public class Utils {
	
	public WebDriver driver;
	
	// constructor that accepts a WebDriver object
    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    // initialization method that creates a new Utils object
    public static Utils initialize(WebDriver driver) {
        return new Utils(driver);
    }

	public void scroll_until(String text) {

		driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", text)));

}
	public void clickOnElementById(String Id) {
		driver.findElement(By.id(Id)).click();

	}
	
	public void clickOnElementByClassName(String className) {
		driver.findElement(By.className(className)).click();

	} 
	public void clickOnElementByXpath(String xPath) {
		driver.findElement(By.xpath(xPath)).click();

	} 
	

	public void longPressByElement(WebElement element, int duration) {
	    HashMap<String, Object> params = new HashMap<>();
	    params.put("elementId", ((RemoteWebElement) element).getId());
	    params.put("duration", duration);
	    ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", params);
	}


	public void longPressById(String id, int duration ) {
	    WebElement element = driver.findElement(By.id(id));
	    longPressByElement(element, duration );
	}

	public void longPressByXpath(String xpath, WebDriver driver, int duration) {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    longPressByElement(element, duration );
	}

	public void longPressByClassName(String className, WebDriver driver, int duration) {
	    WebElement element = driver.findElement(By.className(className));
	    longPressByElement(element, duration );
	}
	public void longPressByCoordinates(int x, int y, int duration) {
	    HashMap<String, Object> params = new HashMap<>();
	    params.put("x", x);
	    params.put("y", y);
	    params.put("duration", duration);
	    ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", params);
	}
	public void doubleClick(WebElement element) {
	     
	        Map<String, Object> params = new HashMap<>();
	        params.put("element", ((RemoteWebElement)element).getId());
	        ((JavascriptExecutor) driver).executeScript("mobile: doubleTap", params);
	    
	}
	public void doubleClickById(String id) {
	    WebElement element = driver.findElement(By.id(id));
	    doubleClick(element);
	}

	public void doubleClickByXPath(String xpath) {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    doubleClick(element);
	}

	public void doubleClickByName(String name) {
	    WebElement element = driver.findElement(By.name(name));
	    doubleClick(element);
	}

	public void doubleClickByClassName(String className) {
	    WebElement element = driver.findElement(By.className(className));
	    doubleClick(element);
	}

	public void doubleClickByCssSelector(String cssSelector) {
	    WebElement element = driver.findElement(By.cssSelector(cssSelector));
	    doubleClick(element);
	}

	public void swipeByCoordinates(int startX, int startY, int endX, int endY, int duration) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("startX", startX);
	    params.put("startY", startY);
	    params.put("endX", endX);
	    params.put("endY", endY);
	    params.put("duration", duration);
	    ((JavascriptExecutor) driver).executeScript("mobile: swipe", params);
	}

	public void swipeByElement(WebElement element, int endX, int endY, int duration) {
	    Rectangle rect = element.getRect();
	    int startX = rect.getX() + rect.getWidth() / 2;
	    int startY = rect.getY() + rect.getHeight() / 2;
	    swipeByCoordinates(startX, startY, endX, endY, duration);
	}

	public void swipeById(String id, int endX, int endY, int duration) {
	    WebElement element = driver.findElement(By.id(id));
	    swipeByElement(element, endX, endY, duration);
	}

	public void swipeByXpath(String xpath, int endX, int endY, int duration) {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    swipeByElement(element, endX, endY, duration);
	}

	public void swipeByClassName(String className, int endX, int endY, int duration) {
	    WebElement element = driver.findElement(By.className(className));
	    swipeByElement(element, endX, endY, duration);
	}
	public void dragAndDropById(String sourceId, String targetId) {
	    WebElement source = driver.findElement(By.id(sourceId));
	    WebElement target = driver.findElement(By.id(targetId));
	    Map<String, Object> params = new HashMap<>();
	    params.put("fromElement", ((RemoteWebElement)source).getId());
	    params.put("toElement", ((RemoteWebElement)target).getId());
	    ((JavascriptExecutor) driver).executeScript("mobile: dragFromToForDuration", params);
	}

	public void flingByElement(WebElement element) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("element", ((RemoteWebElement)element).getId());
	    params.put("direction", "up");  // change this to suit your needs
	    ((JavascriptExecutor) driver).executeScript("mobile: scroll", params);
	}

	public void pinchByElement(WebElement element, double scale, double velocity) {
	    Map<String, Object> params = new HashMap<>();
	    params.put("element", ((RemoteWebElement)element).getId());
	    params.put("scale", scale);  // change this to suit your needs, > 1.0 for zoom in, < 1.0 for zoom out
	    params.put("velocity", velocity);  // change this to suit your needs
	    ((JavascriptExecutor) driver).executeScript("mobile: pinch", params);
	}

	public void pinchById(String id, double scale, double velocity) {
	    WebElement element = driver.findElement(By.id(id));
	    pinchByElement(element, scale, velocity);
	}

	public void flingById(String id) {
	    WebElement element = driver.findElement(By.id(id));
	    flingByElement(element);
	}

	public void dragAndDropByXPath(String sourceXPath, String targetXPath) {
	    WebElement source = driver.findElement(By.xpath(sourceXPath));
	    WebElement target = driver.findElement(By.xpath(targetXPath));
	    Map<String, Object> params = new HashMap<>();
	    params.put("fromElement", ((RemoteWebElement)source).getId());
	    params.put("toElement", ((RemoteWebElement)target).getId());
	    ((JavascriptExecutor) driver).executeScript("mobile: dragFromToForDuration", params);
	}


	
}
