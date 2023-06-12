package automation.learningSeleniumTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SelectMethods {
	WebDriver wd;
	WebDriverWait wait;
	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver","W:\\Driver\\Chrome\\chromedriver.exe");
		wd=new ChromeDriver();
		wait=new WebDriverWait(wd, 7);
		wd.get("https://www.webroot.com/us/en/cart?key=206636B2-ACE5-4D15-B267-16EC7E08A593");
		wd.manage().window().maximize();
	}
	@Test
	public void selectCountry() {
		WebElement selectCountries=wd.findElement(By.cssSelector("select[name='billing.country']"));
		Select country =new Select(selectCountries);
		country.selectByValue("CA");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//country.selectByVisibleText("India"); also work
		WebElement selectStates=wd.findElement(By.cssSelector("select[name='billing.state']"));
		Select states=new Select(selectStates);
	
		states.selectByVisibleText("Ontario");
		
	}
	@AfterMethod
	public void closeBrowser() {
		wd.manage().window().maximize();
		wd.close();
	}
	
}
