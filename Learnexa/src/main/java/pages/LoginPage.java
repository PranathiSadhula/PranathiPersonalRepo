package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class LoginPage extends LearnexaWrappers {
	
	// Assigning the driver and Test
	public LoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Signin button
	public LoginPage clickSigIn() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='form_1491397668']/div[2]/div/div[1]/span[2]/a")).click();

		return this;
	}

	// Click on UserName
	public LoginPage enterUserName() {
		driver.findElement(By.id("email")).sendKeys(sUserName);
		//enterById(prop.getProperty("Login.UserName.id"), UserName);
		return this;
	}

	public LoginPage enterUserName1() {
		driver1.findElement(By.id("email")).sendKeys(sUserName1);
		// enterById(prop.getProperty("Login.UserName.id"), sUserName1);
		return this;
	}

	public LoginPage enterPassword1() {
		driver1.findElement(By.id("password")).sendKeys(sPassword1);
		// enterById(prop.getProperty("Login.Password.id"), sPassword1);
		return this;
	}

	// Click on Password
	public LoginPage enterPassword() {
		enterById(prop.getProperty("Login.Password.id"), sPassword);
		return this;
	}

	// Click on Submit Button
	public HomePage clickSubmit() {
		clickByXpath(prop.getProperty("Login.Submit.Xpath"));
		return new HomePage(driver, test);
	}

	// Testcases for the login
	public HomePage login1() {
		return enterUserName().enterPassword().clickSubmit();

	}

}
