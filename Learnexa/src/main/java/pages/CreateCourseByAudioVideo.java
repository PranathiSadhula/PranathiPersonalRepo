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
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseByAudioVideo extends LearnexaWrappers {

	public CreateCourseByAudioVideo(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	} 
	
	public CreateCourseByAudioVideo clickUploadAVideo() throws InterruptedException {
		Thread.sleep(3000);
		clickById(prop.getProperty("CreateContentByVideoAudioEmbeded.clickUploadAVideo.Id"));
		return this;
	}
	

	public CreateCourseByAudioVideo createContent() throws InterruptedException {
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		return this;
	}
	
	
	public CreateCourseByAudioVideo clickUpload() throws InterruptedException, AWTException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateContentByDocumentation.Upload.Xpath1"));
		Thread.sleep(3000);
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.delay(2000);*/
		r.keyPress(KeyEvent.VK_UP);
		r.delay(4000);
		sikuliObject.type(sTESTDATAAUDIO+ Key.ENTER);
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return this;
		
	}
	
	public CreateCourseByAudioVideo enterTitle(String Title) throws InterruptedException {
		Thread.sleep(3000);
		enterById(prop.getProperty("CreateContentByVideoAudioEmbeded.enterTitle.Id"), Title);
		return this;
	}
	
	public CreateCourseByAudioVideo clickSave() throws InterruptedException {
		Thread.sleep(18000);
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
		savebutton1.click();
		//clickByXpath(prop.getProperty("CreateContentByVideoAudioEmbeded.clickSave.Id"));
		Thread.sleep(5000);
		return this;
	}
	
	public CreateCourseByAudioVideo clickApply() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		return this;	
	}
	
	
	public CreateCourseByAudioVideo enterCourseTitle(String Title) throws InterruptedException {
		Thread.sleep(5000);
		enterById(prop.getProperty("CreateContentByVideoAudioEmbeded.enterCourseTitle.Id"),Title);
		return this;
	}
	
	public CreateCourseByAudioVideo enterDescription() throws InterruptedException {
	driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
	driver.switchTo().parentFrame();
	return this;
	}
	
		
	public CreateCourseByAudioVideo clickSave1(String title) throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateContentByVideoAudioEmbeded.clickSave1.Xpath"));
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
		}
		System.out.println(title);
		return this;	
	}
	
	
}
