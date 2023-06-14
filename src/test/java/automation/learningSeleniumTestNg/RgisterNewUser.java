package automation.learningSeleniumTestNg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.NewSessionPayload;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RgisterNewUser {
	WebDriver driver;
	WebDriverWait wait;
	String firstName="";
	String lastName="";
	String newCustomerEmail="";
	String newPassword="";
	

	@BeforeMethod
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", "W:\\Driver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();
		 firstName=UtilityClass.generateRandomName();
	     lastName=UtilityClass.generateRandomName();
		 newCustomerEmail=lastName+firstName+"@ymail.com";
		 newPassword=UtilityClass.generateRandomName()+"123";
		 
		
	}
                            
	/*@AfterMethod
	public void tearDown() {
		driver.close();
	}*/

	@Test
	// Verify new registration
	public void validateIfNewuserIsRgistered() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys(firstName);
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys(lastName);
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys(newCustomerEmail);
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys(newPassword);
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys(newPassword);

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement agreeCheck = driver.findElement(By.cssSelector(" input[name='agree']"));
		agreeCheck.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		Assert.assertEquals(driver.getTitle(), "Your Account Has Been Created!");
	}

	
	@Test
	// verify if password entered has more than 3 chars
	public void validatePasswordHasMorethan3Chars() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys(firstName);
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys(lastName);
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys(newCustomerEmail);
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

		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Password must be between 4 and 20 characters!']"))
				.isDisplayed(), "if pass word is less than 4 chars warning not given");
	}

	@Test
	// verify user gets warning when confirm password is not matching
	public void validateIfuserGetWarningWhenConfirmPasswordNotMatching() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys(firstName);
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys(lastName);
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys(newCustomerEmail);
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys(newPassword);
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys("pas123");

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement agreeCheck = driver.findElement(By.cssSelector(" input[name='agree']"));
		agreeCheck.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();

		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Password confirmation does not match password!']"))
				.isDisplayed(), "Warning is not present");

	}

	@Test
	// Verify if user is able to register and login back.
	public void validateIfUserIsAbleRegisterAndThenLogin() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys(firstName);
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys(lastName);
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys(newCustomerEmail);
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys(newPassword);
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys(newPassword);

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
		loginEmailInput.sendKeys(newCustomerEmail);
		WebElement loginPasswordInput = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#input-password"))));
		loginPasswordInput.sendKeys(newPassword);
		WebElement loginSubmitBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		loginSubmitBtn.submit();
		Assert.assertEquals(driver.getTitle(), "My Account");

	}
	
	@Test
	// verify user not registered unless privacy policy is checked
	public void validateUserNotRegisteredUnlessPrivacyPolicyIsChecked() {
		WebElement myAccount = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='My Account']"))));
		myAccount.click();
		WebElement registerBtn = wait.until(ExpectedConditions.visibilityOf(
				driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li:nth-child(1) > a"))));
		registerBtn.click();
		WebElement firstnameInput = driver.findElement(By.cssSelector("input#input-firstname"));
		firstnameInput.sendKeys(firstName);
		WebElement lastNameInput = driver.findElement(By.cssSelector("input#input-lastname"));
		lastNameInput.sendKeys(lastName);
		WebElement emailInput = driver.findElement(By.cssSelector("input#input-email"));
		emailInput.sendKeys(newCustomerEmail);
		WebElement telePhone = driver.findElement(By.id("input-telephone"));
		telePhone.sendKeys("1234567");
		WebElement passwordInput = driver.findElement(By.id("input-password"));
		passwordInput.sendKeys(newPassword);
		WebElement confirmPasswordInput = driver.findElement(By.id("input-confirm"));
		confirmPasswordInput.sendKeys(newPassword);

		WebElement subscribeYes = driver.findElement(By.xpath(" (//input[@name='newsletter'])[1]"));
		WebElement subscribeNo = driver.findElement(By.xpath(" (//input[@name='newsletter'])[2]"));
		subscribeNo.click();
		WebElement continueButton = driver.findElement(By.cssSelector(" input[value='Continue']"));
		continueButton.click();
		
			Assert.assertTrue(
					driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed(),"user able to register with unchecked privacy policy");
		} 
			

	

	@Test
	// validate user is not able use existing email id to register
	public void validateIfUserNotAbleToUseExistingEmailToRegister() {
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
		
			Assert.assertTrue(
					driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed(),"user is able use existing email id to register");
		
	}

}
