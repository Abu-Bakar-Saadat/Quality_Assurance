import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Locators {

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
		
		System.setProperty("webdriver.chrome.driver","/Users/abubakar/Documents/Browser-Drivers/chromedriver");
		
		//* For Firefox *//
		
		//System.setProperty("webdriver.gecko.driver","/Users/abubakar/Documents/Browser-Drivers/geckodriver");

		
		//* For Edge *//
		
		//System.setProperty("webdriver.gecko.driver","/Users/abubakar/Documents/Browser-Drivers/msedgedriver");
		
		//*** Invoking Browsers ***//
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		
		//**** Locators ****//
		
		//BY: ID / Xpath / CSS Selector / name / Class Name / Tag Name / Link Text / Partial Link Text
		
		//!! CSS Selector!! //
		//Tagname+ClassName -> Tag.classname -> button.signInBtn ->p.error
		//Tagname+ID -> Tag#ID -> input#iputUsername
		//Tagname+attribute -> button[type="submit"]
		//Tagname+attribute -> input[type="text"]:nth-child()give the index of the css element
		
		//! Parent to Child Traversing CSS !//
		//parenttagname childtagname
		//forms p
		
		//! By regular expression! //
		//butt[type*="sub"]
		
		
		
		
		
		//!! X-Path !!//
		//Tagname+attribute -> //button[@type="submit"]
		//Tagname+attribute if attribute value is common between different fields -> //input[@type='text'][2] give the index 
		
		//! Parent to Child Traversing Xpath !// 
		//parent/tag[index]
		//forms/input[2]
		
		//! XPath regular expression !//
		//button[contains(@class,'submit')]
		
		//* By inspecting elements on URL : https://www.rahulshettyacademy.com/locatorspractice/ */
		// USER NAME FIELD ATTRIBUTES :<input type="text" placeholder="Username" id="inputUsername" value="" data-np-autofill-type="username" data-np-uid="5d2ecfbe-074b-41b2-a4c9-1feee8a2c8ac">
		// PASSWORD FIELD ATTRIBUTES : <input type="password" placeholder="Password" name="inputPassword" value="" data-np-autofill-type="password" data-np-uid="748e1f6e-dc52-4962-935a-6875cd1d4c23">
		// SUBMIT BUTTON ATTRIBUTES: <button class="submit signInBtn" type="submit">Sign In</button>
		// ERROR MESSAGE ATTRIBUTES: <p class="error">* Incorrect username or password </p>
		// NAME ATTRIBUTE ON RESET FORM: <input type="text" placeholder="Name">
		// EMAIL ATTRIBUTE ON RESET FORM: <input type="text" placeholder="Email">
		// PHONE NUMBER ATTRIBUTE ON RESET FORM: <input type="text" placeholder="Phone Number">
		// RESET BUTTON ATTRIBUTE: <button class="reset-pwd-btn">Reset Login</button>
		// INFO MESSAGE ATTRIBUTE ON RESET PAGE: <p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p> 
		// CHECKBOX ATTRIBUTE ON SIGN IN PAGE: <input type="checkbox" id="chkboxOne" name="chkboxOne" value="rmbrUsername" xpath="1">
		//--Find Element By ID--//
		
		driver.findElement(By.id("inputUsername"));
		
		//--Find Element By NAME--//
		
		driver.findElement(By.name("inputPassword"));
		
		//--FInd Element By Class Name--//
		
		driver.findElement(By.className("signInBtn"));
		
		//--Enter Key Strokes--//
		
		driver.findElement(By.id("inputUsername")).sendKeys("xyz@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys("asdflkjh");
		
		//--CLicking on the button--//
		
		driver.findElement(By.className("signInBtn")).click();
		
		//--Retrieving the error message--//
		//--We need to add implicit wait here since the error message will be displayed after some delay and 
		//--if we don't have some implicit wait mechanism, the interpreter will execute the next line 
		//--and throw a message no such element. 
		
		//How to add implicit wait
		
		//--driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2))--//
		//--Adding it to the top so we have it globally
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//--Clicking on the Forgot your password link--//
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//--Adding details on the RESET CREDENTIALS PAGE--//
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("XYZ");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("023243434");
		
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		
		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("XYZ");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");
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
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(By.cssSelector("div p")).getText());
		
		
		
		

	}

}
