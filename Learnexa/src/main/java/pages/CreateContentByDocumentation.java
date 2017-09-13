package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateContentByDocumentation extends LearnexaWrappers {

	public CreateContentByDocumentation(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	// Click on the Documentation
	public CreateContentByDocumentation clickContentDocumentation() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateContentByDocumentation.clickDocuementation.Xpath"));
		Thread.sleep(3000);
		return this;
	}
	
	

	public CreateContentByPresentation clickContentPresentation() throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateContentBy.clickContentPresentation.Xpath"));
		return new CreateContentByPresentation(driver, test);
	}

	// Click on Upload button and selection the file for upload
	public CreateContentByDocumentation clickUpload() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByDocumentation.Upload.Xpath"));
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.delay(2000);*/
		/*r.keyPress(KeyEvent.VK_UP);*/
		r.delay(4000);
		sikuliObject.type(sTESTDATA1+ Key.ENTER);
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return this;
		
	}

	// Enter the Course Title
	public CreateContentByDocumentation enterTitle(String title1) throws InterruptedException {
		/*Thread.sleep(3000);*/
		driver.findElement(By.id("document_title")).sendKeys(title1);
		Thread.sleep(3000);
		//driver.findElement(By.id("submit_document"));
		//enterById(prop.getProperty("CreateContentByDocumentation.enterTitle.Id"),title1);
		return this;
	}

	// Click on Save Button

	public HomePage clickSaveButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Save")).click();
		//clickById(prop.getProperty("HomePage.clickSaveButton.Id"));
/*		Thread.sleep(5000);*/
		return new HomePage(driver, test);
	}
	
	public HomePage clickSaveButton1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("submit_document")).click();
			//clickById(prop.getProperty("HomePage.clickSaveButton.Id"));
/*		Thread.sleep(5000);*/
		return new HomePage(driver, test);
	}

	public HomePage verifycontentcreated(String Title) throws InterruptedException {
		if (driver.getPageSource().contains(Title)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is not Created and validated");
		}
		System.out.println(Title);
		Thread.sleep(4000);
		return new HomePage(driver, test);
	}

	public CreateCourseByDocumentation clickCreateCourse() throws InterruptedException {
		Thread.sleep(4000);
		clickByXpath(prop.getProperty("Home.ClickCreateCourse.Xpath"));
		return new CreateCourseByDocumentation(driver, test);
	}

	public CreateCourseByDocumentation clickCourseDocumentation() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickDocuementation.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseByDocumentation(driver, test);
	}

	public CreateContentByQuiz clickContentQuiz() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickContentQuiz.Xpath"));
		Thread.sleep(3000);
		return new CreateContentByQuiz(driver, test);
	}

	public CreateCourseByDocumentation searchCreatedContent(String Title) throws InterruptedException, AWTException {
		enterById(prop.getProperty("CreateCourseByDocumentation.SearchCreatedContent.id"), Title);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		return new CreateCourseByDocumentation(driver, test);
	}

	public CreateCourseByDocumentation clickcheckBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.ClickcheckBox.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByDocumentation(driver, test);
	}
	
	public CreateCourseByDocumentation createContent() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		return new CreateCourseByDocumentation(driver, test);
	}
	

	public CreateCourseByDocumentation clickApply() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByDocumentation(driver, test);
	}

	public CreateCourseByDocumentation clickCourseTitle() {
		enterById(prop.getProperty("CreateCourseByDocumentation.ClickCourseTitle.Id"), Titledata);
		return new CreateCourseByDocumentation(driver, test);

	}

	public CreateContentByScromPackage clickScromPackage() {
		clickByXpath(prop.getProperty("CreateContentByScromPackage.clickScromPackage.Xpath"));
		return new CreateContentByScromPackage(driver, test);
	}

	public CreateContentByWebPage clickWebPage() throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateContentByWebPage.clickWebPage.Xpath"));
		return new CreateContentByWebPage(driver, test);
	}

	public CreateContentBySurvey clickSurvey() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateContentBySurvey.clickSurvey.Xpath"));
		return new CreateContentBySurvey(driver, test);
	}

	public CreateCourseBySurvey clickSurveybutton() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickSurveybutton.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseBySurvey(driver, test);
	}

	public CreateCourseByQuiz clickQuiz() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateContentByQuiz.clickQuiz.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseByQuiz(driver, test);
	}

	public CreateCourseByDocumentation clickDescription() {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		switchToParentWindow();
		return new CreateCourseByDocumentation(driver, test);
	}

	public CreateCourseByDocumentation checkPrice(String Title) {
		clickById(prop.getProperty("CreateCourseByDocumentation.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByDocumentation.checkPrice1.Id"), Title);
		return new CreateCourseByDocumentation(driver, test);
	}

	public HomePage clickSave1Button() {
		driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		return new HomePage(driver, test);
	}
	
	public CreateContentByTinCan clickTinPackage() {
		clickByXpath(prop.getProperty("CreateContentByTinCan.clickTinPackage.Xpath"));
		return new CreateContentByTinCan(driver,test);
	}

	public HomePage verifycoursecreated(String Title) {
		if (driver.getPageSource().contains(Title)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is not Created and validated");
		}
		System.out.println(Title);
		return new HomePage(driver, test);
	}

}