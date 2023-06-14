package automation.learningSeleniumTestNg;
import java.util.*;


import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {
	
	public static String generateRandomName() {
		Random random = new Random();
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		String randomString = "";
		int length = 7;
		char[] randomChars = new char[length];
		for (int i = 0; i < length; i++) {
			randomChars[i] = alphabets.charAt(random.nextInt(alphabets.length()));
		}
		for (int i = 0; i < length; i++) {
			randomString += randomChars[i];
		}
		return randomString;
	}

}