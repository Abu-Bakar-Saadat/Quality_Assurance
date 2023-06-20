import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import java.time.Duration;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Practice_01_Flightbooking {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/abubakar/Documents/Browser-Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement dropdownElement = driver
				.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		// Create a Select instance

		Select dropdown = new Select(dropdownElement);

		// Select an option by its visible text
		dropdown.selectByVisibleText("USD");

		// Alternatively, select an option by its index
		// dropdown.select_by_index(1)

		// Alternatively, select an option by its value attribute
		// dropdown.select_by_value("option_value")

		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // wait for up to 10 seconds

		// Wait for the dropdown list to appear. Here I'm assuming the dropdown list has
		// an id of "dropdown_list_id".
		// Adjust according to your actual scenario

		WebElement dropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divpaxOptions")));

		int targetValue = 5;
		while (true) {
			String textValue = driver.findElement(By.cssSelector("span[id='spanAudlt']")).getText();
			System.out.println(textValue);
			try {
				int intValue = Integer.parseInt(textValue); // parsing the string to int
				if (intValue < targetValue) {
					driver.findElement(By.cssSelector("span[id='hrefIncAdt']")).click();

				} else {
					// Once the intValue reaches or exceeds the targetValue, break the loop.
					break;
				}
			}

			catch (NumberFormatException e) {
				System.out.println("Cannot parse empty string to integer.");
			}
		}
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

		WebElement depcityList = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']")));
		driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_originStation1_CTNR'] a[value='IXG'] "))
				.click();
		WebElement arrivcityList = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']")));
		driver.findElement(By.cssSelector("div[id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='HYD']"))
				.click();

		Assert.assertEquals(driver.findElement(By.cssSelector("span[id='spanAudlt']")).getText(), "5");

	}

}
