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

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateCourseByTinCan2 extends LearnexaWrappers{
	
	public CreateCourseByTinCan2 (RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	String allowdchrs2 = "123456789";
	
	public CreateCourseByTinCan2 clickTinCan() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByTinCan.clickTinPackage1.Xpath"));
		Thread.sleep(3000);
		//Enter the created content name in the search text field
		driver.findElement(By.id("search")).sendKeys(Titledata);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		return new CreateCourseByTinCan2(driver, test);
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(5000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(8000);
		return new HomePage(driver,test);	
	}
	
	
	public CreateCourseByTinCan2 searchCreatedContent(String title) throws InterruptedException, AWTException{
		Thread.sleep(2000);
		driver.findElement(By.id("search")).sendKeys(title);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		return this;
		
	}
	
	public CreateCourseByTinCan2 checkBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByTinCan.checkBox.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByTinCan2(driver, test);
	}

	public CreateCourseByTinCan2 clickApply() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByTinCan.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByTinCan2(driver, test);
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
	
			
	public HomePage clickSave1Button() {
		driver.findElement(By.id("price_schedule__free_false"));
		WebElement A1=driver.findElement(By.id("price_schedule__price"));
		A1.clear();
		A1.sendKeys(RandomStringUtils.random(1, allowdchrs2));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement savebutton1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("button orange save_button")));
		savebutton1.click();
		//Verify the creation of content
		if(driver.getPageSource().contains(Titledata1)){
			System.out.println("Content is Created and validated");
			}else{
			System.out.println("Content is not Created and not validated");
			}
		System.out.println(Titledata1);
		return new HomePage(driver,test);
	}
	
}
