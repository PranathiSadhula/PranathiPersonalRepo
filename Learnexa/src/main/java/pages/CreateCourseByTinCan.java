package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseByTinCan extends LearnexaWrappers{
	
	public CreateCourseByTinCan (RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	String allowdchrs2 = "123456789";
	
	public CreateCourseByTinCan clickTinCan() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByTinCan.clickTinPackage1.Xpath"));
		Thread.sleep(3000);
		//Enter the created content name in the search text field
		driver.findElement(By.id("search")).sendKeys(Titledata);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		return new CreateCourseByTinCan(driver, test);
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(8000);
		return new HomePage(driver,test);	
	}
	
	/*
	public CreateCourseByTinCan searchCreatedContent(String title) throws InterruptedException, AWTException{
		Thread.sleep(2000);
		driver.findElement(By.id("search")).sendKeys(title);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		return this;
		
	}*/
	
	public CreateCourseByTinCan checkBox() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='form_insert_content_in_course']/div[2]/div/div[2]/ul/li[1]")).click();
		//clickByXpath(prop.getProperty("CreateCourseByScromPackage.checkBox.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByTinCan(driver, test);
	}

	public CreateCourseByTinCan clickApply() throws InterruptedException {
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		//clickByXpath(prop.getProperty("CreateCourseByTinCan.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByTinCan(driver, test);
	}

	public CreateCourseByScromPackage clickCourseTitle(String Title1) throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.id("course_title")).sendKeys(Title1);
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys("Testing Automation");
		driver.switchTo().parentFrame();
	return new CreateCourseByScromPackage(driver, test);

	}
	
			
	public HomePage clickSave1Button(String Title) {
		driver.findElement(By.id("price_schedule__free_false"));
		WebElement A1=driver.findElement(By.id("price_schedule__price"));
		A1.clear();
		A1.sendKeys(Title);
		return new HomePage(driver,test);
	}
		
		public HomePage clickSave2Button(String Title) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		Thread.sleep(4000);
		//Verify the creation of content
		if(driver.getPageSource().contains(Title)){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Courses  is  not Created and validated");
			}
		System.out.println(Title);
		return new HomePage(driver,test);
	}
	
}
