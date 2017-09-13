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
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LearnexaWrappers;

public class CreateContentByTinCan extends LearnexaWrappers{
	
	public CreateContentByTinCan (RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	String allowdchrs2 = "123456789";

	public CreateContentByTinCan clickTinPackage() {
		clickByXpath(prop.getProperty("CreateContentByTinCan.clickTinPackage.Xpath"));
		return this;
	}

	public CreateContentByTinCan clickUpload() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByTinCan.clickUpload.Xpath"));
		Thread.sleep(5000);
		Screen sikuliObject = new Screen();
		Robot r = new Robot();
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);*/
		/*r.delay(2000);*/
		/*r.keyPress(KeyEvent.VK_UP);*/
		r.delay(4000);
		sikuliObject.type(sTESTDATATIN+ Key.ENTER);
		r.delay(2000);
		/*r.keyPress(KeyEvent.VK_DOWN);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);*/
		r.delay(3000);
		return this;
	}

	public CreateContentByTinCan clickTitle(String title2) throws InterruptedException {

		Thread.sleep(7000);
		WebElement Titlename = driver.findElement(By.id("tincan_package_title"));
		Titlename.sendKeys(title2);
		Thread.sleep(5000);
		return this;
	}

	public CreateContentByTinCan clickSaveButton(String Title) throws InterruptedException {

		driver.findElement(By.id("submit_new_document")).click();
			//Verify the creation of content
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//*[@id='my_learning_contents_by_me']/div/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Content is Created and validated");
			}else{
			System.out.println("Content is not Created and validated");
			}
		System.out.println(Title);
		return this;
		}		
	
	
	public CreateCourseByTinCan clickTinCan() throws InterruptedException, AWTException {
		clickByXpath(prop.getProperty("CreateContentByTinCan.clickTinPackage1.Xpath"));
		Thread.sleep(3000);
		//Enter the created content name in the search text field
		/*driver.findElement(By.id("search")).sendKeys(Titledata);
		Robot r1 = new Robot();
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);*/
		return new CreateCourseByTinCan(driver, test);
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(6000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(8000);
		return new HomePage(driver,test);	
	}
	
	public CreateCourseByTinCan checkBox() throws InterruptedException {
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("CreateCourseByTinCan.checkBox.Xpath"));
		Thread.sleep(6000);
		return new CreateCourseByTinCan(driver, test);
	}

	public CreateCourseByTinCan clickApply() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseByTinCan.clickApply.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseByTinCan(driver, test);
	}

	public CreateCourseByScromPackage clickCourseTitle(String Tite1) throws InterruptedException {
		Thread.sleep(3000);

	 driver.findElement(By.id("course_title")).sendKeys(Tite1);
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
		driver.findElement(By.xpath("//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		Thread.sleep(4000);
		//Verify the creation of content
		if(driver.getPageSource().contains(Title)){
			System.out.println("Content is Created and validated");
			}else{
			System.out.println("Courses  is  not Created and validated");
			}
		System.out.println(Title);
		return new HomePage(driver,test);
	}
	
		
		public HomePage verifycoursecreated() {
		if (driver.getPageSource().contains(Titledata)) {
			System.out.println("Content is Created and validated");
		} else {
			System.out.println("Content is Created and validated");
		}
		System.out.println(Titledata);
		return new HomePage(driver, test);
	}
	

}
