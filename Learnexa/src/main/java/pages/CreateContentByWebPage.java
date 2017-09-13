package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateContentByWebPage extends LearnexaWrappers {

	public CreateContentByWebPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public CreateContentByWebPage clickWebPage() {
		clickByXpath(prop.getProperty("CreateContentByWebPage.clickWebPage.Xpath"));
		return this;
	}
	
	public CreateCourseByDocumentation createContent() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		return new CreateCourseByDocumentation(driver, test);
	}

	public CreateContentByWebPage switchframe() throws InterruptedException {

		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);*/
		driver.switchTo().frame("web_text_text_ifr");
		// click on webpage editing
		driver.findElement(By.id("tinymce"))
				.sendKeys("Birds are special " + "kind of animal species with certain "
						+ "specific characteristics that are common to all of them."
						+ " All of them are feathered, winged, bipedal"
						+ " (meaning: having two legs), egg-laying, warm blooded, vertebrate animals "
						+ "belonging to the class Aves. They are an important part of "
						+ "the ecosystem and are present across the globe from the" + " Arctic to the Antarctic.");
		//Thread.sleep(7000);
		driver.switchTo().defaultContent();
		return this;
	}

	public CreateContentByWebPage clickTitle(String title) throws InterruptedException {
		WebElement Titlename = driver.findElement(By.id("web_text_title"));
		Titlename.sendKeys(title);
		Thread.sleep(3000);
		return this;
	}

	public CreateContentByWebPage clickSaveButton(String Title) throws InterruptedException {
		/*Thread.sleep(4000);*/
		Thread.sleep(4000);
		clickById(prop.getProperty("CreateContentByWebPage.clickSaveButton.Id"));
		Thread.sleep(4000);
		// Verify the creation of content
		
		return this;
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(3000);
		return new HomePage(driver,test);	
	}
	
	public CreateCourseByWebPage clickWebPageButton(){
		clickByXpath(prop.getProperty("CreateCourseByWebPage.clickWebPageButton.Xpath"));
		return new CreateCourseByWebPage(driver,test);
			}
	
	public CreateCourseByWebPage enterContentSearch(String title) throws InterruptedException, AWTException {
		driver.findElement(By.id("search")).sendKeys(title);
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		return new CreateCourseByWebPage(driver, test);
	}
	
	public CreateCourseByWebPage clickcheckBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByWebPage.clickcheckBox.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseByWebPage(driver, test);
	}

	public CreateCourseByWebPage clickApply() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByWebPage.clickApply.Xpath"));
	/*	Thread.sleep(3000);*/
		return new CreateCourseByWebPage(driver, test);
	}
	
	public CreateCourseByWebPage clickDescription() throws InterruptedException {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		driver.switchTo().parentFrame();
	/*	Thread.sleep(3000);*/
		return new CreateCourseByWebPage(driver, test);
	}
	
	public CreateCourseByWebPage clickTitle1(String Title1) throws InterruptedException {
		Thread.sleep(3000);
		WebElement Titlename1 = driver.findElement(By.id("course_title"));
		Titlename1.sendKeys(Title1);
		return new CreateCourseByWebPage(driver, test);
	}
	
	
	public CreateCourseByWebPage saveButton1(String Title){
		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("button orange save_button")));
		savebutton1.click();
		//Verify the creation of content
		if(driver.getPageSource().contains(Title)){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
			}
		System.out.println(Title);
		return new CreateCourseByWebPage(driver, test);
	}
	
	
	
	
}


