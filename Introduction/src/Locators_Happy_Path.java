import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Locators_Happy_Path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver","/Users/abubakar/Documents/Browser-Drivers/geckodriver");
		WebDriver driver = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String name="XYZ";
		String Password = getpassword(driver);
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.className("signInBtn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] p")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}

	public static String getpassword(WebDriver driver) {
		
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		
		
		String Passwordtext=driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login
		String[] Passwordtext_split = Passwordtext.split("'");
		String Password = Passwordtext_split[1].split("'")[0];
		return Password;
		
		
	}
}
