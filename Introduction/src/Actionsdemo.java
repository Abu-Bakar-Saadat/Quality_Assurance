import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionsdemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/abubakar/Documents/Browser-Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions a= new Actions(driver);
		WebElement e= driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		//Move to Specific Element
		a.moveToElement(e).contextClick().build().perform();
		//composite actions
		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("Tablet").doubleClick().build().perform();
		
		
		// TODO Auto-generated method stub

	}

}
