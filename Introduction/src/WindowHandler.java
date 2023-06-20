import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandler {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/abubakar/Documents/Browser-Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set <String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentwindow=it.next();
		String childwindow=it.next();
		driver.switchTo().window(childwindow);
		String email=driver.findElement(By.cssSelector("a[href='mailto:mentor@rahulshettyacademy.com']")).getText();
		System.out.println(email);
		driver.switchTo().window(parentwindow);
		a.moveToElement(driver.findElement(By.id("username"))).click().sendKeys(email);
		a.moveToElement(driver.findElement(By.id("password"))).click().sendKeys(email);
		
		// TODO Auto-generated method stub

	}


}
