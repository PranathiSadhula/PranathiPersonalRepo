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
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateContentByScromPackage extends LearnexaWrappers {

	public CreateContentByScromPackage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	String allowdchrs2 = "123456789";

	public CreateContentByScromPackage clickScromPackage() {
		clickByXpath(prop.getProperty("CreateContentByScromPackage.clickScromPackage.Xpath"));
		return this;
	}

	public CreateContentByScromPackage clickUpload() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByScromPackage.clickUpload.Xpath"));
		Thread.sleep(5000);
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.delay(2000);*/
		/*r.keyPress(KeyEvent.VK_UP);*/
		r.delay(4000);
		sikuliObject.type(sTESTDATASCORM+ Key.ENTER);
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return this;
	}

	public CreateContentByScromPackage clickTitle(String title) throws InterruptedException {

		Thread.sleep(5000);
		driver.findElement(By.id("scorm_package_title")).sendKeys(title);
		Thread.sleep(5000);
		return this;
	}

	public CreateContentByScromPackage clickSaveButton(String Title2) throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.id("submit_new_document")).click();
		Thread.sleep(4000);
		/*// Verify the creation of content
		if(driver.findElement(By.xpath("//*[@id='my_learning_contents_by_me']/div/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Content is Created and validated");
			}else{
			System.out.println("Content is not Created and validated");
			}*/
		//System.out.println(Title2);
		return this;
	}
	 
	
	public CreateCourseByScromPackage clickScromPackage1() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateCourseByScromPackage.clickScromPackage1.Xpath"));
		Thread.sleep(3000);
		//Enter the created content name in the search text field
		driver.findElement(By.id("search")).sendKeys(Titledata);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		return new CreateCourseByScromPackage(driver, test);
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(6000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(3000);
		return new HomePage(driver,test);	
	}
	
	public CreateCourseByScromPackage checkBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByScromPackage.checkBox.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByScromPackage(driver, test);
	}

	public CreateCourseByScromPackage clickApply() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByScromPackage.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByScromPackage(driver, test);
	}

	public CreateCourseByScromPackage clickCourseTitle() throws InterruptedException {
		Thread.sleep(3000);

		WebElement Titlename1 = driver.findElement(By.id("course_title"));
		String Titledata1 = "TESTING" + RandomStringUtils.random(2, allowdchrs2);
		Titlename1.sendKeys(Titledata1);
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		driver.switchTo().parentFrame();
	return new CreateCourseByScromPackage(driver, test);

	}
	
	public CreateCourseByQuiz checkPrice() throws InterruptedException {
		//clickById(prop.getProperty("CreateCourseByQuiz.checkPrice.Id"));
		enterById(prop.getProperty("CreateCourseByQuiz.checkPrice1.Id"), Titledata2);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false"));
		return new CreateCourseByQuiz(driver, test);
	} 
	
	
			
	public HomePage clickSave1Button() {
		driver.findElement(By.id("price_schedule__free_false"));
		WebElement A1=driver.findElement(By.id("price_schedule__price"));
		A1.clear();
		A1.sendKeys(RandomStringUtils.random(1, allowdchrs2));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_new_document")));
		savebutton1.click();
		//Verify the creation of content
		if(driver.getPageSource().contains(Titledata1)){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
			}
		System.out.println(Titledata1);
		return new HomePage(driver,test);
	}
		
		public HomePage verifycoursecreated(String Title1) {
		if (driver.getPageSource().contains(Title1)) {
			System.out.println("Course is Created and validated");
		} else {
			System.out.println("Course is not Created and validated");
		}
		System.out.println(Title1);
		return new HomePage(driver, test);
	}
	


}
