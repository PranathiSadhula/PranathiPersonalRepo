package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateContentByVideoAudioEmbeded extends LearnexaWrappers {

	public CreateContentByVideoAudioEmbeded(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	// Click on the Video
	public CreateContentByVideoAudioEmbeded clickContentVideoAudio() throws InterruptedException {
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateContentByVideoAudioEmbeded.clickContentVideoAudio.Xpath"));
		return this;
	}
	

	public CreateContentByVideoAudioEmbeded createContent() throws InterruptedException {
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateCourseByDocumentation.createContent.Xpath"));
		Thread.sleep(3000);
		return this;
	}

	public CreateContentByVideoAudioEmbeded enterEmbedUrl() throws InterruptedException {
		Thread.sleep(4000);
		enterById(prop.getProperty("CreateContentByVideoAudioEmbeded.enterEmbedUrl.Id"), sTESTDATAVIDEOEMBEDED);
		return new CreateContentByVideoAudioEmbeded(driver, test);
	}

	// Click the button embedded
	public CreateContentByVideoAudioEmbeded clickEmbedButton() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateContentByVideoAudioEmbeded.clickEmbedButton.Xpath"));
		return this;
	}

	public CreateContentByVideoAudioEmbeded enterTitle(String Title) throws InterruptedException {
		Thread.sleep(3000);
		enterById(prop.getProperty("CreateContentByVideoAudioEmbeded.enterTitle.Id"), Title);
		return this;
	}
	
	public CreateCourseByAudioVideo clickUploadAVideo() throws InterruptedException {
		Thread.sleep(3000);
		clickById(prop.getProperty("CreateContentByVideoAudioEmbeded.clickUploadAVideo.Id"));
		return new CreateCourseByAudioVideo(driver,test);
	}

	public CreateContentByVideoAudioEmbeded clickSaveButton() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("submit_document")).click();
		Thread.sleep(3000);
		//clickById(prop.getProperty("HomePage.clickSaveButton.Id"));
/*		Thread.sleep(5000);*/
		return new CreateContentByVideoAudioEmbeded(driver, test);
	}
	
	public CreateContentByVideoAudioEmbeded enterCourseTitle(String Title) throws InterruptedException {
		Thread.sleep(5000);
		enterById(prop.getProperty("CreateContentByVideoAudioEmbeded.enterCourseTitle.Id"),Title);
		return this;
	}
	
	public CreateContentByVideoAudioEmbeded enterDescription() throws InterruptedException {
	driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
	driver.switchTo().parentFrame();
	return this;
	}

	
	public CreateContentByVideoAudioEmbeded clickApply() throws InterruptedException {
		Thread.sleep(4000);
		//*[@id="content_listing_panel"]/div[2]/ul/li[2]/a
		//*[@id="content_listing_panel"]/div[2]/ul/li[2]/a
		//System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//System.out.println("bbbbbbbbbbbbbbbbbbbbb");
		//driver.findElement(By.id("content_listing_panel")).findElements(By.tagName("div")).get(1).findElements(By.tagName("ul")).get(0).findElements(By.tagName("li")).get(1).findElements(By.tagName("a")).get(0).click();
		
		//driver.findElement(By.id("content_listing_panel")).findElements(By.ByTagName(""))]/div[2]/ul/li[2]/a")).click();
		Thread.sleep(3000);
		return this;	
	}
	
	public CreateContentByVideoAudioEmbeded clickSave1(String title) throws InterruptedException {
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
