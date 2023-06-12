package automation.learningSeleniumTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import junit.framework.Assert;
import org.testng.Assert;

public class LoginPage {
	WebDriver wd;
	@BeforeMethod
public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "W:\\Driver\\Chrome\\chromedriver.exe");
		wd=new ChromeDriver();
	wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
}
	@Test
	public void tc001() {
		WebElement continueBtn= wd.findElement(By.cssSelector("  a.btn.btn-primary"));
		continueBtn.click();
		WebElement firstnameInput = wd.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys("Scott");
		WebElement lastNameInput = wd.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys("William");
		WebElement emailInput = wd.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys("william@scott.com124588");
		WebElement telePhone = wd.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = wd.findElement(By.id("input-password"));
		passwordInput.sendKeys("password123");
		WebElement confirmPasswordInput = wd.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys("password123");
		
		WebElement subscribeYes = wd.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = wd.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement agreeCheck = wd.findElement(By.cssSelector(" input[name='agree']"));
		agreeCheck.click();
		WebElement continueButton = wd.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		Assert.assertEquals(wd.getTitle(), "Your Account Has Been Created");
		
		WebElement logOutButton=wd.findElement(By.cssSelector("div > a:nth-child(13)"));
		logOutButton.click();
		Assert.assertEquals(wd.getTitle(),"Account Logout");
		
	} 
	@Test
	public void tc002() {
	  
		WebElement loginEmailInput=wd.findElement(By.id("input-email"));
		loginEmailInput.sendKeys("william@scott.com");
		WebElement loginPasswordInput=wd.findElement(By.id("input-password"));
		loginPasswordInput.sendKeys("password123");
		WebElement loginButton=wd.findElement(By.cssSelector("input[value='Login']"));
		loginButton.click();
		Assert.assertEquals(wd.getTitle(),"My Account" );
		
	}
	
}
