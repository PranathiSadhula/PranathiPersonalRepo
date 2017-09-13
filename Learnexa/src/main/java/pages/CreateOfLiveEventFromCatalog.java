package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateOfLiveEventFromCatalog extends LearnexaWrappers{
	
	public CreateOfLiveEventFromCatalog(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}
	
	public CreateOfLiveEventFromCatalog clickCatalog1() throws InterruptedException {
		clickById(prop.getProperty("CreateCourseFromCatalog.clickCatalog.Id"));
		Thread.sleep(6000);
		return new CreateOfLiveEventFromCatalog(driver, test);
	}
	
	public CreationOfLiveEvents UploadPresentation() throws AWTException, InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateEvents.UploadPresentation.Xpath"));
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.delay(2000);*/
/*		r.keyPress(KeyEvent.VK_UP);*/
		r.delay(2000);
		sikuliObject.type(sTESTDATAPRESENTATION+ Key.ENTER);
		r.delay(2000);
	/*	r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return new CreationOfLiveEvents(driver,test);	
		}
	
	public CreateOfLiveEventFromCatalog clickCreate1() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseFromCatalog.clickCreate.Xpath"));
		Thread.sleep(3000);
		return new CreateOfLiveEventFromCatalog(driver,test);		
	}
	
	public CreationOfInPersonEvent clickEvents1() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateEvents.clickEvents.Xpath"));
		Thread.sleep(3000);
		return new CreationOfInPersonEvent(driver,test);	
	}
	
	

	public CreationOfLiveEvents clickInPerson() throws InterruptedException{
		clickByXpath(prop.getProperty("CreateEvents.clickInPerson.Id"));
		Thread.sleep(3000);
		return new CreationOfLiveEvents(driver,test);
	}
	
	public CreationOfBundle clickBundleButton() throws InterruptedException {
		clickByXpath(prop.getProperty("CreationOfBundle.clickBundleButton.Xpath"));
		return new CreationOfBundle(driver,test);
	}
	
	
	public CreationOfBundle clickAddButton() throws InterruptedException{
		//click add content button
		driver.findElement(By.id("popupTitleLink")).findElements(By.tagName("a")).get(0).click();
		Thread.sleep(6000);
		
		//select the content from the listing
		driver.findElements(By.id("content_id_")).get(0).click();
		driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a")).click();
		Thread.sleep(6000);
		return new CreationOfBundle(driver,test);
	}
	

	public CreateOfLiveEventFromCatalog clickLiveEvents() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateOfLiveEventFromCatalog.clickLiveEvents.Xpath"));
		Thread.sleep(3000);
		return new CreateOfLiveEventFromCatalog(driver,test);		
	}
	

}
