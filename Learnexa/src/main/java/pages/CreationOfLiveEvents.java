package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreationOfLiveEvents  extends LearnexaWrappers {
	
	public CreationOfLiveEvents(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}
	
	public CreationOfLiveEvents clickEvents() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateEvents.clickEvents.Xpath"));
		return this;	
	}
	
	public CreationOfLiveEvents clickCreation(){
		clickById(prop.getProperty("CreateEvents.clickCreaticn.Id"));
		clickByXpath(prop.getProperty("CreateEvents.clickCreation.Xpath"));	
		return this;
	}
	
	public CreationOfInPersonEvent enterTitle(String title) throws InterruptedException{
		Thread.sleep(5000);
		enterById(prop.getProperty("CreationOfInPersonEvent.enterTitle.Id"),title);
		return new  CreationOfInPersonEvent(driver,test);	
	}
	
	public CreationOfLiveEvents UploadPresentation() throws AWTException, InterruptedException{
		clickByXpath(prop.getProperty("CreateEvents.UploadPresentation.Xpath"));
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.delay(2000);*/
/*		r.keyPress(KeyEvent.VK_UP);*/
		r.delay(4000);
		sikuliObject.type(sTESTDATAPRESENTATION+ Key.ENTER);
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		/*Thread.sleep(5000);*/
		/*WebElement element =driver.findElementByXPath(".//*[@id='upload']/div[1]");
		element.sendKeys("/home/user/Test.docx");
		element.sendKeys((Keys.RETURN));*/
		/*clickByXpath(prop.getProperty("CreateEvents.UploadPresentation.Xpath"));
		Thread.sleep(3000);
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(4000);
		sikuliObject.type(sTESTDATAPRESENTATION + Key.ENTER);
		r.delay(8000);	*/
		return this;	
		}
	
	public CreationOfLiveEvents clickLiveEventTitle(String title) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(By.id("live_event_title")).sendKeys(title);
		System.out.println("XPATH ENtered");
		Thread.sleep(3000);
		return this;
	}
	
	public CreationOfLiveEvents clickDescription(){
		driver.switchTo().frame("live_event_description_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		driver.switchTo().parentFrame();
		return this;
	}
	
	public CreationOfInPersonEvent clickInPersonEvent() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("CreateEvents.clickInPersonEvent.Xpath"));
		return new CreationOfInPersonEvent(driver,test) ;	
	}
	
	
	public CreationOfLiveEvents clickSaveButton1(String Title) throws InterruptedException{
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.linkText("Save"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//driver.findElement(By.linkText("Save"));
		/*Thread.sleep(8000);*/
		System.out.println("Save button is clicked");
		Thread.sleep(5000);
		return this;
	}
	
	public CreationOfLiveEvents clickSaveButton(String Title) throws InterruptedException{
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.linkText("Save"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//driver.findElement(By.linkText("Save")).click();
		/*Thread.sleep(8000);*/
		System.out.println("Save button is clicked");
		Thread.sleep(5000);
		
		if(driver.findElement(By.xpath(".//*[@class='my_learnings_live_event columns']/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Live Event is Created and validated");
			}else{
			System.out.println("Live Event is not Created and validated");
		}
		
		System.out.println(Title);
			return this;
		}
	}

	
	


