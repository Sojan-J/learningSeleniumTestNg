package automation.learningSeleniumTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePassword {
	static WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void startUP() {
		System.setProperty("webdriver.chrome.driver", "W:\\Driver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	//verify if user is able change the password
	public void VerifyRegisteredUserAbleToChangeThePassword() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(2) > a"))));
		registerBtn.click();
		WebElement loginEmailInput = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("input-email"))));
		loginEmailInput.sendKeys("davis20@scott.com1245");
		WebElement loginPasswordInput = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("input-password"))));
		loginPasswordInput.sendKeys("password567");
		WebElement loginBtn = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='Login']"))));
		loginBtn.submit();
		WebElement changePassword = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Change your password']"))));
		changePassword.click();
		WebElement changePasswordInput = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("input-password"))));
		changePasswordInput.sendKeys("password12");
		WebElement confirmPassword = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("input-confirm"))));
		confirmPassword.sendKeys("password12");
		WebElement continueBtn = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input[value='Continue']"))));
		continueBtn.submit();

		Assert.assertTrue(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).isDisplayed(),
				"Registered user not able to change the password");

	}

	@Test
	// verify if user is able login back once the password is changed
	public void verifyIfUserIsAbleToLoginBackOncePasswordIsChanged() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement loginBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(2) > a"))));
		loginBtn.click();
		WebElement loginEmailInput = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("input-email"))));
		loginEmailInput.sendKeys("davis20@scott.com1245");
		WebElement loginPasswordInput = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#input-password"))));
		loginPasswordInput.sendKeys("password12");
		WebElement loginSubmitBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginSubmitBtn.submit();
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
	
}
