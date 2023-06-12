package automation.learningSeleniumTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class ContactNaveenAutomation {
	
	
	WebDriver wd;
	WebDriverWait wait;
	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver","W:\\Driver\\Chrome\\chromedriver.exe");
		wd=new ChromeDriver();
		wait=new WebDriverWait(wd, 7);
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		wd.manage().window().maximize();
	}
	
	@Test
	public void contactNaveenAuto() {
		WebElement contact= wait.until
				(ExpectedConditions.visibilityOf
						(wd.findElement(By.cssSelector(" div:nth-child(2) > ul.list-unstyled> li:nth-child(1) > a"))));
		contact.click();
		WebElement nameInput=wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.id("input-name"))));
		nameInput.sendKeys("sojan");
		WebElement emailInput=wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.id("input-email"))));
		emailInput.sendKeys("sojan@jose.com");
		WebElement enquiryInput=wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.id("input-enquiry"))));
		enquiryInput.sendKeys("would like to receive more about upcoming courses");
		WebElement submitBtn=wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//input[@value='Submit']"))));
		submitBtn.submit();
		WebElement sentSuccesss =wait.until
				(ExpectedConditions.visibilityOf
						(wd.findElement(By.xpath("//p[text()='Your enquiry has been successfully sent to the store owner!']"))));
     Assert.assertEquals("Your enquiry has been successfully sent to the store owner!", sentSuccesss.getText());
	}
	@AfterMethod
	public void closebrowser() {
		wd.manage().window().maximize();
		//wd.close();
	}

}
