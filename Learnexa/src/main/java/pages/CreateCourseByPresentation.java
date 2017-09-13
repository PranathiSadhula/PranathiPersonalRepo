package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseByPresentation extends LearnexaWrappers {
	
	public CreateCourseByPresentation(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}
	
	
	public CreateCourseByDocumentation clickCreateCourse() throws InterruptedException{
		clickByXpath(prop.getProperty("Home.ClickCreateCourse.Xpath"));
		Thread.sleep(4000);
		return new CreateCourseByDocumentation(driver, test);	
	}
	
	public CreateCourseByDocumentation createContent() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		return new CreateCourseByDocumentation(driver, test);
	}
	
	
	public CreateCourseByPresentation clickCoursePresentaion() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByPresentation.clickPresentaion.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByPresentation(driver, test);
	}

	public CreateCourseByPresentation searchCreatedContent(String title) throws InterruptedException, AWTException {
		enterById(prop.getProperty("CreateCourseByPresentation.searchCreatedContent.id"), title);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		return new CreateCourseByPresentation(driver, test);
	}
	
	

	public CreateCourseByPresentation clickcheckBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByPresentation.ClickcheckBox.Xpath"));
		return new CreateCourseByPresentation(driver, test);
	}

	public CreateCourseByPresentation clickApply() throws InterruptedException {
		Thread.sleep(4000);
		clickByXpath(prop.getProperty("CreateCourseByPresentation.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByPresentation(driver, test);
	}

	public CreateCourseByPresentation clickCourseTitle(String Title) {
		enterById(prop.getProperty("CreateCourseByPresentation.ClickCourseTitle.Id"), Title);
		return new CreateCourseByPresentation(driver, test);

	}
	
	public CreateCourseByPresentation clickDescription() {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
		switchToParentWindow();
		return new CreateCourseByPresentation(driver, test);
	}
	
	public CreateCourseByPresentation checkPrice() throws InterruptedException {
		/*clickById(prop.getProperty("CreateCourseByPresentation.checkPrice.Id"));
		Thread.sleep(2000);*/
		enterById(prop.getProperty("CreateCourseByPresentation.checkPrice1.Id"), Titledata2);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false")).click();
		return new CreateCourseByPresentation(driver, test);
	} 
	
	public HomePage clickSave1Button() throws InterruptedException {

		clickByXpath(prop.getProperty("HomePage.clickSave1Button.Xpath"));
		Thread.sleep(5000);
		return new HomePage(driver, test);
	}

	public HomePage verifycoursecreated(String Title) {
		if (driver.getPageSource().contains(Title)) {
			System.out.println("Course is Created and validated");
		} else {
			System.out.println("Course is not Created and validated");
		}
		System.out.println(Title);
		return new HomePage(driver, test);
	}
	
	public HomePage clickEdit() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElementByXPath("HomePage.clickEdit.Xpath");
		return new HomePage(driver, test);
	}
	
	public CreateCourseByPresentation clickCourseTitle1(String Titledata1) {
		
		enterById(prop.getProperty("CreateCourseByPresentation.ClickCourseTitle.Id"), Titledata1);
		return new CreateCourseByPresentation(driver, test);

	}
	
	public CreateCourseByPresentation clickUpdateSave(String title) throws InterruptedException{
		/*Thread.sleep(4000);*/
		driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/input")).click();
		//clickByXpath("CreateCourseByPresentation.clickUpdateSave.Xpath");
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Course is Updated and validated");
			}else{
			System.out.println("Course is not Updated and validated");
			}
		
		return new CreateCourseByPresentation(driver, test);
		
	}

	public CardDeclinedPayment clickPresentationContent()
	{
		clickByXpath(prop.getProperty("NegativePaymentFlow.clickPresentationContent.Xpath"));
		return new CardDeclinedPayment(driver,test) ;
	}
	
	
	
	
	}



