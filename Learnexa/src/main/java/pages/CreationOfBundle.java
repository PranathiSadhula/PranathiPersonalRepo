package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreationOfBundle extends LearnexaWrappers {

	public CreationOfBundle(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	public CreationOfBundle clickBundle() throws InterruptedException {
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreationOfBundle.clickBundle.Xpath"));
		return this;
	}

	public CreationOfBundle clickCreateBundle() throws InterruptedException {
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreationOfBundle.clickCreateBundle.Xpath"));
		return this;
	}

	public CreationOfBundle clickAddButton() throws InterruptedException {
		clickByXpath(prop.getProperty("CreationOfBundle.clickAddButton.Xpath"));
		return this;
	}
	
	public CreationOfBundle clickBundleButton() throws InterruptedException {
		clickByXpath(prop.getProperty("CreationOfBundle.clickBundleButton.Xpath"));
		return this;
	}

	public CreationOfBundle clickSearch(String title) throws InterruptedException, AWTException {
		enterById(prop.getProperty("CreationOfBundle.clickSearch.Id"), title);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		return new CreationOfBundle(driver, test);
	}

	public CreationOfBundle clickcheckBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreationOfBundle.clickcheckBox.Xpath"));
		Thread.sleep(3000);
		return new CreationOfBundle(driver, test);
	}

	public CreationOfBundle clickApply() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//driver.findElementByXPath(".//*[@id='content_listing_panel']/div[2]/ul/li[2]/a").click();		//clickByXpath(prop.getProperty("CreationOfBundle.clickApply.Xpath"));
		Thread.sleep(5000);
		return new CreationOfBundle(driver, test);
	}

	public CreationOfBundle clickCourseTitle(String Title) throws InterruptedException {
		Thread.sleep(3000);
		enterById(prop.getProperty("CreationOfBundle.ClickCourseTitle.Id"), Title);
		Thread.sleep(3000);
		return new CreationOfBundle(driver, test);

	}

	public CreationOfBundle clickDescription() {
		driver.switchTo().frame("bundle_description_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
		driver.switchTo().parentFrame();
		return new CreationOfBundle(driver, test);
	}

	/*public CreateCourseByQuiz checkPrice() throws InterruptedException {
		// clickById(prop.getProperty("CreateCourseByQuiz.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByQuiz.checkPrice1.Id"), Titledata2);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false"));
		return new CreateCourseByQuiz(driver, test);
	}
*/
	public HomePage clickSave1Button() {
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='new_course_form']/div[3]/ul/li[2]/div/input")));
		savebutton1.click();
		return new HomePage(driver, test);
	}

	public HomePage verifycoursecreated(String title) {
		if (driver.getPageSource().contains(title)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is Created and validated");
		}
		System.out.println(Titledata);
		return new HomePage(driver, test);
	}

}
