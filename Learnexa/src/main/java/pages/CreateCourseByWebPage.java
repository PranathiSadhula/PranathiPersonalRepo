package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseByWebPage extends LearnexaWrappers {
	
	public CreateCourseByWebPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}
	
	public CreateCourseByWebPage clickSurverButton(){
		clickByXpath(prop.getProperty("CreateContentByWebPage.clickSaveButton.Xpath"));
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
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("CreateCourseByWebPage.clickcheckBox.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseByWebPage(driver, test);
	}

	public CreateCourseByWebPage clickApply() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		return new CreateCourseByWebPage(driver, test);
	}
	
	public CreateCourseByWebPage clickDescription() throws InterruptedException {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
		driver.switchTo().parentFrame();
		System.out.println("Description Typed");
	/*	Thread.sleep(3000);*/
		return new CreateCourseByWebPage(driver, test);
	}
	
	public CreateCourseByWebPage clickTitle1(String Title) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("course_title")).sendKeys(Title);
		/*Thread.sleep(3000);*/
		return new CreateCourseByWebPage(driver, test);
	}
	
	
	public CreateCourseByWebPage saveButton1(String Title) throws InterruptedException{
		
		driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		Thread.sleep(3000);
		//Verify the creation of content
		if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
			}
		System.out.println(Title);
		return new CreateCourseByWebPage(driver, test);
	}

}
