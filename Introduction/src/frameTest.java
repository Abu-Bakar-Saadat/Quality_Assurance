import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/abubakar/Documents/Browser-Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		Actions a = new Actions(driver);
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		a.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
		driver.switchTo().defaultContent();

	}

}
