import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
public class SeliniumIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//invoking browsers
		//chrome chromedriver -> methods close,get
		//Firefox firefoxdriver -> methods close, get
		//Safari safaribrowser -> methods close, get
		//WebDriver interface  -> All classes(FirefoxDriver,ChromeDriver,SafariDriver-
		//-implement methods present in WebDriver
		
	
		
		//*** Setting driver paths ***//
		
		//* For Chrome *?//
		
		//System.setProperty("webdriver.chrome.driver","/Users/abubakar/Documents/Browser-Drivers/chromedriver");
		
		//* For Firefox *//
		
		//System.setProperty("webdriver.gecko.driver","/Users/abubakar/Documents/Browser-Drivers/geckodriver");

		
		//* For Edge *//
		
		System.setProperty("webdriver.gecko.driver","/Users/abubakar/Documents/Browser-Drivers/msedgedriver");
		
		//*** Invoking Browsers ***//
		
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new EdgeDriver();
		
		//*** Methods ***//	
		
		
		driver.get("http://www.rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close(); // closes the current window on which operations are being performed in the invoked browser
		//driver.quit(); is another method that closes all the associated windows opened in our invoked browser
		

	}

}
