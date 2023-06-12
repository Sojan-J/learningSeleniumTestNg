package automation.learningSeleniumTestNg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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

public class RgisterNewUser {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "W:\\Driver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@Test
	// Verify new registration
	public void tc001() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys("Scott");
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys("William");
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys("william@scott.com1245");
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys("password123");
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys("password123");

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement agreeCheck = driver.findElement(By.cssSelector(" input[name='agree']"));
		agreeCheck.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created");
	}
	@Test
	// verify email format
	public void tc002() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement emailInput = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#input-email"))));
		emailInput.sendKeys("williamscottcom1245");
		// wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(isalertPresent(), "Email format warning is not present");

	}

	@Test
	// verify if password entered has more than 3 chars
	public void tc003() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys("Scott");
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys("William");
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys("william@scott.com1000");
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys("pas");
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys("pas");

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement agreeCheck = driver.findElement(By.cssSelector(" input[name='agree']"));
		agreeCheck.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		try {
			Assert.assertTrue(
					driver.findElement(By.xpath("//div[text()='Password must be between 4 and 20 characters!']"))
							.isDisplayed());
		} catch (NoSuchElementException ex) {
			Assert.assertTrue(false, " warning  is not given when password entered is less than 4 chars");
		}
	}

	@Test
	// verify user gets warning when confirm password is not matching
	public void tc004() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys("Scott");
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys("William");
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys("william@scott.com1000");
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys("pas1234");
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys("pas123");

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement agreeCheck = driver.findElement(By.cssSelector(" input[name='agree']"));
		agreeCheck.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		try {
			Assert.assertTrue(
					driver.findElement(By.xpath("//div[text()='Password confirmation does not match password!']"))
							.isDisplayed(),
					"Warning is not present");
		} catch (NoSuchElementException ex) {
			Assert.assertTrue(false, "Warning is not present when user enter miss matched password");
		}

	}

	@Test
	// Verify if user is able to register and login back.
	public void tc005() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys("Scott");
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys("Davis");
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys("davis20@scott.com1245");
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys("password123");
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys("password123");

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement agreeCheck = driver.findElement(By.cssSelector(" input[name='agree']"));
		agreeCheck.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		WebElement logOutButton = driver.findElement(By.cssSelector("div > a:nth-child(13)"));
		logOutButton.click();
		myAccount = wait
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
		loginPasswordInput.sendKeys("password123");
		WebElement loginSubmitBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginSubmitBtn.submit();
		Assert.assertEquals(driver.getTitle(), "My Account");

	}
	
	@Test
	// verify user not registered unless privacy policy is checked
	public void tc006() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys("Scott");
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys("William");
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys("william@scott.com1245");
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys("password123");
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys("password123");

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		try {
			Assert.assertTrue(
					driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed());
		} catch (NoSuchElementException ex) {
			Assert.assertTrue(false, "no warning is given when privacy policy is unchecked");
		}

	}

	@Test
	// validate user is not able use existing email id to register
	public void tc007() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys("Scott");
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys("William");
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys("davis20@scott.com1245");
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys("password123");
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys("password123");

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement agreeCheck = driver.findElement(By.cssSelector(" input[name='agree']"));
		agreeCheck.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		try {
			Assert.assertTrue(
					driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed());
		} catch (NoSuchElementException ex) {
			Assert.assertTrue(
					driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed(),
					"No warning given when existing email is used");
		}
	}
	
	
	public boolean isalertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

}
