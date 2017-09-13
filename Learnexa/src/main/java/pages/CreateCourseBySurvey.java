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

public class CreateCourseBySurvey extends LearnexaWrappers{

	public CreateCourseBySurvey(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		
	}

	public CreateCourseBySurvey clickSurveybutton() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickSurveybutton.Xpath"));
		Thread.sleep(3000);
		return new CreateCourseBySurvey(driver, test);
	}
	
	public HomePage clickcoursetab() throws InterruptedException{
		Thread.sleep(2000);
		clickByXpath(prop.getProperty("Home.ClickCourse.Xpath"));
		Thread.sleep(6000);
		return new HomePage(driver,test);	
	}
	/*public  CreateCourseBySurvey clickSearch(String title) throws InterruptedException, AWTException {
		driver.findElement(By.id("search")).sendKeys(title);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		return new CreateCourseBySurvey(driver, test);
		
	}*/
	public CreateCourseBySurvey clickcheckBox() throws InterruptedException {
		clickByXpath(prop.getProperty("CreateCourseBySurvey.clickcheckBox.Xpath"));
		Thread.sleep(2000);
		return new CreateCourseBySurvey(driver, test);
	}

	public CreateCourseBySurvey clickApply() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//*[@id='content_listing_panel']/div[2]/ul/li[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element);
		Thread.sleep(3000);
		return new CreateCourseBySurvey(driver, test);
	}

	public CreateCourseBySurvey clickCourseTitle(String title) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("course_title")).sendKeys(title);
		Thread.sleep(3000);
		return new CreateCourseBySurvey(driver, test);

	}
	
	public CreateCourseBySurvey clickDescription() {
		driver.switchTo().frame("course_raw_data_ifr").findElement(By.id("tinymce")).sendKeys(sTESTDATADESCRIPTION);
		driver.switchTo().parentFrame();
		return new CreateCourseBySurvey(driver, test);
	}
	
	public CreateCourseBySurvey checkPrice() throws InterruptedException {
		Thread.sleep(2000);
		enterById(prop.getProperty("CreateCourseByQuiz.checkPrice1.Id"), Titledata2);
		Thread.sleep(3000);
		driver.findElement(By.id("price_schedule__free_false"));
		return new CreateCourseBySurvey(driver, test);
	} 
	
	public HomePage clickSave1Button(String Title) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='new_course_panel']/div[4]/ul/li[2]/div/input")).click();
		Thread.sleep(3000);
		//Verify the creation of content
		if(driver.findElement(By.xpath("//*[@id='my_learning_courses']/div/div/div/div/div/div/div/div/div/a"))!= null){
			System.out.println("Course is Created and validated");
			}else{
			System.out.println("Course is not Created and validated");
		}
			System.out.println(Title);
		return new HomePage(driver, test);
			
			}
		
}
