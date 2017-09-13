package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateContentByPresentation extends LearnexaWrappers {

	public CreateContentByPresentation(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	// Click on the Documentation
	public CreateContentByPresentation clickContentPresentation() throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateContentBy.clickContentPresentation.Xpath"));
		return this;
	}

	// Click on Upload button and selection the file for upload
	public CreateContentByPresentation clickUpload() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByPresentation.Upload.Xpath"));

		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_UP);*/
		r.delay(4000);
		sikuliObject.type(sTESTDATA1 + Key.ENTER);
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return this;
	}

	public CreateCourseByDocumentation createContent() throws InterruptedException {
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByDocumentation(driver, test);
	}

	// Enter the Course Title
	public CreateContentByPresentation enterTitle(String title) throws InterruptedException {
		Thread.sleep(5000);
		enterById(prop.getProperty("CreateContentByPresentation.enterTitle.Id"), title);
		Thread.sleep(4000);
		return this;
	}

	// Click on Save Button
	public HomePage clickSaveButton() throws InterruptedException {
		Thread.sleep(4000);
		clickById(prop.getProperty("HomePage.clickSaveButton.Id"));

		return new HomePage(driver, test);
	}

	public HomePage verifycontentcreated(String Title) throws InterruptedException {
		Thread.sleep(5000);
		if (driver.getPageSource().contains(Title)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is Not Created and validated");
		}
		System.out.println(Title);
		Thread.sleep(4000);
		return new HomePage(driver, test);
	}

	public CreateCourseByPresentation clickCoursePresentaion() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByPresentation.clickPresentaion.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByPresentation(driver, test);
	}

	public CreateCourseByPresentation searchCreatedContent(String data) throws InterruptedException, AWTException {
		enterById(prop.getProperty("CreateCourseByPresentation.searchCreatedContent.id"), Titledata);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		return new CreateCourseByPresentation(driver, test);
	}

	public CreateCourseByPresentation clickcheckBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByPresentation.ClickcheckBox.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByPresentation(driver, test);
	}

	public CreateCourseByPresentation clickApply() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByPresentation.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByPresentation(driver, test);
	}

	public CreateCourseByPresentation clickCourseTitle() {
		enterById(prop.getProperty("CreateCourseByPresentation.ClickCourseTitle.Id"), Titledata);
		return new CreateCourseByPresentation(driver, test);

	}

	public CreateCourseByPresentation clickDescription() {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		driver.switchTo().parentFrame();
		return new CreateCourseByPresentation(driver, test);
	}

	public CreateCourseByPresentation checkPrice() {
		clickById(prop.getProperty("CreateCourseByPresentation.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByPresentation.checkPrice1.Id"), Titledata1);
		return new CreateCourseByPresentation(driver, test);
	}

	public HomePage clickSave1Button() {
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")));
		savebutton1.click();
		return new HomePage(driver, test);
	}

	public HomePage verifycoursecreated(String Title) {
		if (driver.getPageSource().contains(Title)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is Not Created and validated");
		}
		System.out.println(Title);
		return new HomePage(driver, test);
	}

	public CreateCourseByPresentation clickUpdateSave(String title) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/input")).click();
		// clickByXpath("CreateCourseByPresentation.clickUpdateSave.Xpath");
		if (driver.getPageSource().contains(title)) {
			System.out.println("Course is Updated and validated");
		}
		System.out.println(title);

		return new CreateCourseByPresentation(driver, test);

	}

}
